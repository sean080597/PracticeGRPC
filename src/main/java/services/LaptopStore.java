package services;

import stubs.Laptop;

public interface LaptopStore {
  void save(Laptop laptop) throws Exception;

  Laptop find(String id);
}
