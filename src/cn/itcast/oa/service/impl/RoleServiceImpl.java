package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IRoleDao;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.IRoleService;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{
	@Resource
	private IRoleDao roleDao;
	@Override
	public void save(Role model) {
		// TODO Auto-generated method stub
		roleDao.save(model);
	}

	@Override
	public void delete(Role model) {
		// TODO Auto-generated method stub
		roleDao.delete(model.getId());
	}

	@Override
	public void update(Role model) {
		// TODO Auto-generated method stub
		roleDao.update(model);
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		return roleDao.findById(id);
	}

	@Override
	public List<Role> findByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return roleDao.findByIds(ids);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}
	
}
