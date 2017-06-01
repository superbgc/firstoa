package cn.itcast.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{
	@Resource
	SessionFactory sessionFactory;
	@Override
	public int findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		String hql="from User u where u.loginName= ?";
		return (int) this.getSession().createQuery(hql).setParameter(0, loginName).uniqueResult();
	}
	

}
