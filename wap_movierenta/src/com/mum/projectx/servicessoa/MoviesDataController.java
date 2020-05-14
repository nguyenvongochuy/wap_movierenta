package com.mum.projectx.servicessoa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mum.projectx.convertors.JsonConvertor;
import com.mum.projectx.listener.AppContextListener;
import com.mum.projectx.model.Movie;
import com.mum.projectx.repository.MovieRepositoryInterface;
import com.mum.projectx.repository.RepositoryFactory;
import com.mum.projectx.storage.StorageInterface;

/**
 * Servlet implementation for service SOA return all movies Data
 */
@WebServlet({ "/MoviesDataController", "/moviesdata"})
public class MoviesDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesDataController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			StorageInterface storage = (StorageInterface) request.getServletContext().getAttribute(AppContextListener.STORAGE);
			MovieRepositoryInterface movieRepository = RepositoryFactory.createMovieRepository(storage);
			JsonConvertor jsonConverter = new JsonConvertor(null);
		
			List<Movie> movies = movieRepository.getAll();
			response.setContentType("application/json");
	        
	        response.getWriter().println(jsonConverter.toJson(movies)); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
