package com.mum.projectx.repository;

import java.util.List;

public interface RepositoryInterface<T> {
	T get(long id);
	List<T> getAll();
	void save(T entity);
}