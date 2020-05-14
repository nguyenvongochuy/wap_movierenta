package com.mum.projectx.model;

public class Order {
	private long id;
	private long userId;
	private long movieId;
	private String movieTitle;
	private String token;
	private String dateOrdered;
	
	public Order() {
	}

	public Order(long id, long userId, long movieId, String movieTitle, String token, String dateOrdered) {
		super();
		this.id = id;
		this.userId = userId;
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.token = token;
		this.dateOrdered = dateOrdered;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	
	
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", movieId=" + movieId + ", movieTitle=" + movieTitle
				+ ", token=" + token + ", dateOrdered=" + dateOrdered + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOrdered == null) ? 0 : dateOrdered.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (movieId ^ (movieId >>> 32));
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (dateOrdered == null) {
			if (other.dateOrdered != null)
				return false;
		} else if (!dateOrdered.equals(other.dateOrdered))
			return false;
		if (id != other.id)
			return false;
		if (movieId != other.movieId)
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
	

}
