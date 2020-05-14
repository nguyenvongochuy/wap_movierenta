package com.mum.projectx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.listener.AppContextListener;
import com.mum.projectx.listener.RequestListener;
import com.mum.projectx.model.User;
import com.mum.projectx.repository.RepositoryFactory;
import com.mum.projectx.repository.UserRepositoryInterface;
import com.mum.projectx.storage.StorageInterface;
import com.mum.projectx.util.JwtUtil;

@WebServlet({ "/SignUpController", "/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    try {
	      JsonConvertor jsonConvertor = (JsonConvertor)request.getAttribute(RequestListener.BODY);
	      User user = jsonConvertor.toObject(User.class);
	      if (user != null) {
	        StorageInterface storage = (StorageInterface)request.getServletContext().getAttribute(AppContextListener.STORAGE);
	        UserRepositoryInterface userRepository = RepositoryFactory.createUserRepository(storage);
	        User users_result = userRepository.findByUserNameAndPassword(user.getUsername(), user.getPassword());

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        if(users_result != null) {
	        	out.print("{\"error\": \"Account taken.\" }");
	        } else {
	        	userRepository.save(user);
	        	users_result = user;
	        	String jwt = JwtUtil.createJWT("signup", users_result.getUsername(), -1);
	        	out.print("{\"token\": \"" + jwt + "\", \"fullname\": \"" + users_result.getFullname() + "\", \"isAdmin\": "
	  	              + users_result.isAdmin() + "}");
	        }
	      } else {
	        out.print("{\"error\": \"Your token is invalid.\" }");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	      out.print("{\"error\": \"Server error.\" }");
	    } finally {
	      out.flush();
	    }
	}
}
