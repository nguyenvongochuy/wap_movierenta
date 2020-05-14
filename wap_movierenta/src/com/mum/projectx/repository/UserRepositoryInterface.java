package com.mum.projectx.repository;

import com.mum.projectx.model.User;

public interface UserRepositoryInterface extends RepositoryInterface<User> {
	User findByUserNameAndPassword(String username, String password);
	User findByUserName(String username);
}