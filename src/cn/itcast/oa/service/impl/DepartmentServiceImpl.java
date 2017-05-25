package cn.itcast.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.service.IDepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
	@Resource
	protected IDepartmentDao departmentDao;

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	public Department findById(Long id) {
		// TODO Auto-generated method stub
		return departmentDao.findById(id);
	}
	
}
