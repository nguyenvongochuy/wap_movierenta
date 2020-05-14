package com.mum.projectx.repository;

import com.mum.projectx.model.Order;

public interface OrderRepositoryInterface extends RepositoryInterface<Order> {
	public Order findByUserIdAndMovieId(long userId, long movieId);
	public Order findByToken(String token);
}
