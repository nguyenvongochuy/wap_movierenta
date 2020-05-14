package com.mum.projectx.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.listener.AppContextListener;
import com.mum.projectx.listener.RequestListener;
import com.mum.projectx.model.Movie;
import com.mum.projectx.model.Order;
import com.mum.projectx.model.User;
import com.mum.projectx.repository.MovieRepositoryInterface;
import com.mum.projectx.repository.OrderRepositoryInterface;
import com.mum.projectx.repository.RepositoryFactory;
import com.mum.projectx.repository.UserRepositoryInterface;
import com.mum.projectx.storage.StorageInterface;
import com.mum.projectx.util.OrderUtils;

/**
 * Servlet implementation for service SOA add 1 order
 */
@WebServlet({ "/AddOrderController", "/addorder"})
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object username = request.getAttribute(RequestListener.USERNAME);
		JsonConvertor jsonConverter = (JsonConvertor) request.getAttribute(RequestListener.BODY);
		if (username!=null) {
			StorageInterface storage = (StorageInterface) request.getServletContext().getAttribute(AppContextListener.STORAGE);
			UserRepositoryInterface userRepository = RepositoryFactory.createUserRepository(storage);
			OrderRepositoryInterface orderRepository = RepositoryFactory.createOrderRepository(storage);
			MovieRepositoryInterface movieRepository = RepositoryFactory.createMovieRepository(storage);
			User user = userRepository.findByUserName(username.toString());
			if (user!=null) {
				long userId = user.getId();
				Order order = jsonConverter.toObject(Order.class);
				Movie movie = movieRepository.get(order.getMovieId());
				if (movie!=null) {
					order.setToken(OrderUtils.generateOrderNumber());
					order.setUserId(userId);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
				    Date date = new Date();  
					order.setDateOrdered(formatter.format(date));
					order.setMovieTitle(movieRepository.get(order.getMovieId()).getTitle());
					order.setMovieTitle(movie.getTitle());
					//add more attribute to Order and then save to json
					orderRepository.save(order);
					response.setContentType("application/json");
			        response.getWriter().println("{\"token\":" + "\"" +order.getToken() + "\"}"); 
					return;
				} else {
					response.setContentType("application/json");
			        response.getWriter().println("{\"error\": \"Movie does not exist\" }"); 
			        return;
				}
			}
		}
		response.setContentType("application/json");
        response.getWriter().println("{\"error\": \"Do not login\" }"); 
	}
}
