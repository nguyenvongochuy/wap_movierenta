package com.mum.projectx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.listener.AppContextListener;
import com.mum.projectx.model.Movie;
import com.mum.projectx.model.Order;
import com.mum.projectx.repository.MovieRepositoryInterface;
import com.mum.projectx.repository.OrderRepositoryInterface;
import com.mum.projectx.repository.RepositoryFactory;
import com.mum.projectx.storage.StorageInterface;

/**
 * Servlet implementation class ThankYouController
 */
@WebServlet({ "/ThankYouDataController", "/thankyoudata"})
public class ThankYouDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThankYouDataController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		StorageInterface storage = (StorageInterface) request.getServletContext().getAttribute(AppContextListener.STORAGE);
		OrderRepositoryInterface orderRepository = RepositoryFactory.createOrderRepository(storage);
		MovieRepositoryInterface movieRepository = RepositoryFactory.createMovieRepository(storage);
		
		JsonConvertor jsonConverter = new JsonConvertor(null);
		
		if (token!=null) {
			Order order = orderRepository.findByToken(token);
			if (order!=null) {
				Movie movie = movieRepository.get(order.getMovieId());
				String bothJson = "[{\"order\": "+jsonConverter.toJson(order)+"}, { \"movie\": "+jsonConverter.toJson(movie)+"}]";
				response.setContentType("application/json");
		        response.getWriter().println(bothJson); 
		        return;
			}
		
		}
		response.setContentType("application/json");
        response.getWriter().println("{\"error\": \"Movie token is invalid.\" }"); 
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
