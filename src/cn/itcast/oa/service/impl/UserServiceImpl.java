package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	//@Autowired
	@Resource
	private IUserDao userDao;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void delete(User model) {
		// TODO Auto-generated method stub
	 userDao.delete(model.getId());
	}

	@Override
	public void save(User model) {
		// TODO Auto-generated method stub
		userDao.save(model);
	}

	@Override
	public void update(User model) {
		// TODO Auto-generated method stub
		userDao.update(model);
	}

	@Override
	public int findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDao.findByLoginName(loginName);
	}

}
