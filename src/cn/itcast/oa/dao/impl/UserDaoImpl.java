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
	@Override
	public int findByLoginName(String loginName) {
		/**
		 * 根据登录名统计
		 */
			String hql = "SELECT COUNT(id) FROM User u WHERE u.loginName = ?";
			Long count = (Long) this.getSession().createQuery(hql).setParameter(0, loginName).uniqueResult();
			return count.intValue();
		}
	}

