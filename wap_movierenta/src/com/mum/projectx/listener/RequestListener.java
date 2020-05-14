package com.mum.projectx.listener;

import java.io.BufferedReader;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.util.JwtUtil;

@WebListener("Request listener")
public class RequestListener implements ServletRequestListener {

  public static String USERNAME = "USERNAME";
  public static String BODY = "BODY_JSON";

  public void requestDestroyed(ServletRequestEvent event) {
  }

  public void requestInitialized(ServletRequestEvent event) {
    HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
    if (request != null) {
      // extract Authorization header to get token and then decode it to get username
      String authorization = request.getHeader("Authorization");
      if (authorization != null) {
        authorization = authorization.replace("Bearer ", "");
        String username = JwtUtil.decodeJWT(authorization).getSubject();
        request.setAttribute(USERNAME, username);
      }

      //json data
      String contentType = request.getHeader("Content-Type");
      if ("application/json".equalsIgnoreCase(contentType) && "POST".equalsIgnoreCase(request.getMethod())) {
        try {
          BufferedReader reader = request.getReader();
          request.setAttribute(BODY, new JsonConvertor(reader));
        } catch (Exception e) {
          request.setAttribute(BODY, new JsonConvertor(null));
        }
      }
    }
  }
}
