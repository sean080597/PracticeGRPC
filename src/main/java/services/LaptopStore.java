package services;

import io.grpc.Context;
import stubs.Filter;
import stubs.Laptop;

public interface LaptopStore {
  void save(Laptop laptop) throws Exception;
  Laptop find(String id);
  void Search(Context ctx, Filter filter, LaptopStream stream);
}
