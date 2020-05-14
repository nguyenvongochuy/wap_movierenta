package com.mum.projectx.repository;

import com.mum.projectx.storage.StorageInterface;

public class RepositoryFactory {
  
  public static UserRepositoryInterface createUserRepository(StorageInterface storage) {
    return new UserRepository(storage);
  }

  public static MovieRepositoryInterface createMovieRepository(StorageInterface storage) {
    return new MovieRepository(storage);
  }

  public static OrderRepositoryInterface createOrderRepository(StorageInterface storage) {
    return new OrderRepository(storage);
  }
  
}