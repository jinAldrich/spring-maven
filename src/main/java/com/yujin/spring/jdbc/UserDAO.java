package com.yujin.spring.jdbc;

import java.util.List;

public interface UserDAO {

	public void save(User user);
	public void delete(int id);
	public void update(User user);
	public User findById(int id);
	public List<User> findAll();
}
