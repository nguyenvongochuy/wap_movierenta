package com.mum.projectx.storage;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.GsonBuilder;
import com.mum.projectx.model.Data;
import com.mum.projectx.model.Movie;
import com.mum.projectx.model.Order;
import com.mum.projectx.model.User;

public class FileStorage implements StorageInterface {
  private String dbPath;
  private Data data;

  private FileStorage(String dbPath) {
    this.dbPath = dbPath;
  }

  public static StorageInterface create(String dbPath) {
    return new FileStorage(dbPath);
  }

  public Data getData() {
    if (this.data == null) {
      try {
        FileReader reader = new FileReader(this.dbPath);
        this.data = new GsonBuilder().create().fromJson(reader, Data.class);
        reader.close();
      } catch (Exception e) {
        this.data = new Data(new Movie[0], new Order[0], new User[0]);
      }
    }
    return this.data;
  }
  public void saveData(Data data) {
    if (data != null) {
      FileWriter writer;
      try {
        writer = new FileWriter(this.dbPath);
        writer.write(new GsonBuilder().create().toJson(data));
        writer.flush();
        writer.close();
        this.data = data;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}