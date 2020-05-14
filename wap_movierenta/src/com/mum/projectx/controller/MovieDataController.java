package com.mum.projectx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.listener.AppContextListener;
import com.mum.projectx.listener.RequestListener;
import com.mum.projectx.model.Movie;
import com.mum.projectx.model.User;
import com.mum.projectx.repository.MovieRepositoryInterface;
import com.mum.projectx.repository.OrderRepositoryInterface;
import com.mum.projectx.repository.RepositoryFactory;
import com.mum.projectx.repository.UserRepositoryInterface;
import com.mum.projectx.storage.StorageInterface;

@WebServlet({ "/MovieDetailsController", "/moviedata" })
public class MovieDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StorageInterface storage = (StorageInterface) request.getServletContext().getAttribute(AppContextListener.STORAGE);
		MovieRepositoryInterface movieRepository = RepositoryFactory.createMovieRepository(storage);
		String movieId = request.getParameter("id");
		Movie movie = null;
		if (movieId!=null) {
			movie = movieRepository.get(Long.parseLong(movieId));
			Object username = request.getAttribute(RequestListener.USERNAME);
			boolean isBought = false;
			if (username != null) {
				UserRepositoryInterface userRepository = RepositoryFactory.createUserRepository(storage);
				User user = userRepository.findByUserName(username.toString());
				if (user!=null) {
					long userId = user.getId();
					OrderRepositoryInterface orderRepository = RepositoryFactory.createOrderRepository(storage);
					isBought = orderRepository.findByUserIdAndMovieId(userId, Long.parseLong(movieId)) != null;
				}
			}
			
			JsonConvertor jsonConvertor = new JsonConvertor(null);
			String bothJson = "[{\"isBought\": " + isBought + "}, {\"movie\": " + jsonConvertor.toJson(movie) + "}]";
			response.setContentType("application/json");
			response.getWriter().println(bothJson);
			return;
		}
		
		response.setContentType("application/json");
		response.getWriter().println("{\"error\": \"Movie item does not find.\" }");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
