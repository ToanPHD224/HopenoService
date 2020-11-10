package com.hope.Service;

import java.util.List;

public interface CrudEnties<T> {
	public List<T> findAll();
	public void update(T enties);
	public void save(T entites);
	public T getById(long id);
	public void delete(T entites);

}
