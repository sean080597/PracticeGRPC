package services;

import io.grpc.Context;
import stubs.Filter;
import stubs.Laptop;
import stubs.Memory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InMemoryLaptopStore implements LaptopStore {
  private static final Logger logger = Logger.getLogger(InMemoryLaptopStore.class.getName());
  private final ConcurrentHashMap<String, Laptop> data;

  public InMemoryLaptopStore() {
    data = new ConcurrentHashMap<>(0);
  }

  @Override
  public void save(Laptop laptop) throws Exception {
    if (data.containsKey(laptop.getId())) {
      throw new AlreadyExistsException("Laptop ID already exists");
    }

    Laptop other = laptop.toBuilder().build();
    data.put(other.getId(), other);
  }

  @Override
  public Laptop find(String id) {
    if (!data.containsKey(id)) {
      return null;
    }
    return data.get(id).toBuilder().build();
  }

  @Override
  public void Search(Context ctx, Filter filter, LaptopStream stream) {
    for (Map.Entry<String, Laptop> entry : data.entrySet()){
      if(ctx.isCancelled()){
        logger.info("context is cancelled");
        return;
      }

      try{
        TimeUnit.SECONDS.sleep(1);
      }catch (InterruptedException ex){
        ex.printStackTrace();
      }
      Laptop laptop = entry.getValue();
      if (isQualified(filter, laptop)){
        stream.Send(laptop.toBuilder().build());
      }
    }
  }

  private boolean isQualified(Filter filter, Laptop laptop) {
    if(laptop.getPriceUsd() > filter.getMaxPriceUsd()){
      return false;
    }

    if (laptop.getCpu().getNumberCores() < filter.getMinCpuCores()){
      return false;
    }

    if(laptop.getCpu().getMinGhz() < filter.getMinCpuGhz()){
      return false;
    }

    return toBit(laptop.getRam()) >= toBit(filter.getMinRam());
  }

  private long toBit(Memory memory) {
    long value = memory.getValue();

    switch (memory.getUnit()){
      case BIT:
        return value;
      case BYTE:
        return value << 3; // 1 BYTE = 8 BIT = 2^3 BIT
      case KILOBYTE:
        return value << 13;// 1 KB = 1024 Byte = 2^10 Byte = 2^13 BIT
      case MEGABYTE:
        return value << 23;
      case GIGABYTE:
        return value << 33;
      case TERABYTE:
        return value << 43;
      default:
        return 0;
    }
  }


}
