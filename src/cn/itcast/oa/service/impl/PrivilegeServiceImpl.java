package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.oa.dao.IPrivilegeDao;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.service.IPrivilegeService;
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {
	//@Resource
	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	public List<Privilege> findTopList() {
		// TODO Auto-generated method stub
		return privilegeDao.findTopList();
	}

	@Override
	public List<Privilege> findByIds(Long[] privilegeIds) {
		// TODO Auto-generated method stub
		return privilegeDao.findByIds(privilegeIds);
	}

	@Override
	public List<Privilege> findAll() {
		// TODO Auto-generated method stub
		return privilegeDao.findAll();
	}
}
