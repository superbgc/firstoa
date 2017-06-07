package cn.itcast.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IPrivilegeDao;
import cn.itcast.oa.domain.Privilege;
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements IPrivilegeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findTopList() {
		String hql="from Privilege d where d.parent is null";
		
		return this.getSession().createQuery(hql).list();
	}
	
}
