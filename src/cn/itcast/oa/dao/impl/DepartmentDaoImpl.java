package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IDepartmentDao;
import cn.itcast.oa.domain.Department;
@Repository
@SuppressWarnings("unchecked")
@Transactional
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements IDepartmentDao {

	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		String hql="from Department d where d.parent is null";
		
		return this.getSession().createQuery(hql).list();
	}

	
	@Override
	public List<Department> findChildList(Long parentId) {
		// TODO Auto-generated method stub
		String hql="from Department d where d.parent.id= ?";
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
	}
		
}
