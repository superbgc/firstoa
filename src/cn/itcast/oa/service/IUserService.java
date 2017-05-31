package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.User;

public interface IUserService{

	List<User> findAll();

	User findById(Long id);

	void delete(User model);

	void save(User model);

	
	
}
