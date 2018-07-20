package com.fengwuj.Dao;

import java.util.List;

import com.fengwuj.entity.User;

public interface Dao {
	
	public boolean add(Object object);
	
	public boolean delete(String name);
	
	public boolean edit(Object object);
	
	public User select(String name) ;
	
	public List<User> selectAll(String table);
	
}
