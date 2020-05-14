package com.mum.projectx.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mum.projectx.storage.FileStorage;
import com.mum.projectx.storage.StorageInterface;

@WebListener("Application Context Listener")
public class AppContextListener implements ServletContextListener {

  static final String SEPARATOR = System.getProperty("file.separator");
  public static String STORAGE = "FILE_STORAGE";

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext ctx = sce.getServletContext();
    String dbFile = ctx.getRealPath("/WEB-INF/database.json");
    StorageInterface storage = FileStorage.create(dbFile);
    ctx.setAttribute(STORAGE, storage);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
  
}