package services;

import stubs.Laptop;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLaptopStore implements LaptopStore {
  private ConcurrentHashMap<String, Laptop> data;

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

    Laptop other = data.get(id).toBuilder().build();
    return other;
  }
}
