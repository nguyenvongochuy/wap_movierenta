package com.mum.projectx.model;

public class Data {
	private Movie[] movies;
	private Order[] orders;
	private User[] users;

	public Data(Movie[] movies, Order[] orders, User[] users) {
		this.movies = movies;
		this.orders = orders;
		this.users = users;
	}

	public Movie[] getMovies() {
		return movies;
	}

	public void setMovies(Movie[] movies) {
		this.movies = movies;
	}

	public Order[] getOrders() {
		return orders;
	}

	public void setOrders(Order[] orders) {
		this.orders = orders;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Data [movies=" + movies + ", orders=" + orders + ", users=" + users + "]";
	}
	
	

}
