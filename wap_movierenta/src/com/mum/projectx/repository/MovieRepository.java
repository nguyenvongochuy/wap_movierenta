package com.mum.projectx.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mum.projectx.model.Data;
import com.mum.projectx.model.Movie;
import com.mum.projectx.storage.StorageInterface;

class MovieRepository implements MovieRepositoryInterface {
  private StorageInterface storage;
  private Data data;

  private void ensureData() {
	    this.data = storage.getData();
  }
  
  MovieRepository(StorageInterface storage) {
    this.storage = storage;
  }

  @Override
  public Movie get(long id) {
	Optional<Movie> movie = this.getAll().stream().filter(m -> m.getId() == id).findFirst();
	if (movie.isPresent()) {
		return movie.get();
	}
	return null;
  }

  @Override
  public List<Movie> getAll() {
    ensureData();
    List<Movie> movies = new ArrayList<>();
    movies.addAll(Arrays.asList(this.data.getMovies()));
    return movies;
  }

  @Override
  public void save(Movie entity) {
    Movie movie = get(entity.getId());
    if (movie!=null) { //update case
    	movie.setTitle(entity.getTitle());
    	movie.setBackdrop_path(entity.getBackdrop_path());
    	movie.setDuration(entity.getDuration());
    	movie.setOverview(entity.getOverview());
    	movie.setPoster_path(entity.getPoster_path());
    	movie.setRelease_date(entity.getRelease_date());
    	movie.setVote_average(entity.getVote_average());
    	
    } else { //add case
    	List<Movie> movies = getAll();
    	long maxId = movies.stream().mapToLong(u -> (Long)u.getId()).max().orElseGet(() -> 0);
        entity.setId(maxId + 1); 
    	movies.add(entity);
    	// sync data
    	this.data.setMovies(movies.toArray(new Movie[movies.size()]));
    }
    this.storage.saveData(data);
  }
}