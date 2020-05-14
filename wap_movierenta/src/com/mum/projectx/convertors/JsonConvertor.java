package com.mum.projectx.convertors;

import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConvertor {
  private Gson gson;
  private Reader reader;

  public JsonConvertor(Reader reader) {
    this.reader = reader;
    this.gson = new GsonBuilder().create();
  }

  public <T> T toObject(Class<T> typeOfT) {
    if (this.reader == null) return null;
    return new Gson().fromJson(this.reader, typeOfT);
  }

  public String toJson(Object data) {
    return this.gson.toJson(data);
  }
}