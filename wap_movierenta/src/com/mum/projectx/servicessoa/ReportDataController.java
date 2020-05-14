package com.mum.projectx.servicessoa;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
 * Servlet implementation class ReportDataController
 */
@WebServlet({ "/ReportDataController", "/reportData"})
public class ReportDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StorageInterface storage = (StorageInterface) request.getServletContext().getAttribute(AppContextListener.STORAGE);
		JsonConvertor jsonConverter = new JsonConvertor(null);	
		
		Map<String, Object> data = new HashMap<>();
		
		String dataType = request.getParameter("datatype");
		if(dataType.equals("demand")) {
			OrderRepositoryInterface orderRepository = RepositoryFactory.createOrderRepository(storage);
			List<Order> orders = orderRepository.getAll();
			Map<String, Long> counting = orders.stream()
					.filter(o -> o.getMovieTitle() != null)
					.collect(Collectors.groupingBy(Order::getMovieTitle, Collectors.counting()))
					.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.limit(10)
					.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
			System.out.println(counting.keySet());
			String[] movies = counting.keySet().toArray(new String[counting.size()]);
			Long[] demands = counting.values().toArray(new Long[counting.size()]);
			data.put("xAxis", movies);
			data.put("yAxis", demands);
		}else {
			MovieRepositoryInterface moiveRepository = RepositoryFactory.createMovieRepository(storage);
			List<Movie> movies = moiveRepository.getAll().stream()
					.sorted(Comparator.comparing(Movie::getVote_average).reversed())
					.limit(10)
					.collect(Collectors.toList());
			
			data.put("xAxis", movies.stream().map(m->m.getTitle()).collect(Collectors.toList()));
			data.put("yAxis", movies.stream().map(m->m.getVote_average()).collect(Collectors.toList()));
		}
		
		response.setContentType("application/json");
        response.getWriter().println(jsonConverter.toJson(data)); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
