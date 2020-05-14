package com.mum.projectx.storage;

import com.mum.projectx.model.Data;

public interface StorageInterface {
  Data getData();
  void saveData(Data data);
}