package cn.itcast.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.itcast.oa.base.BaseDaoImpl;
import cn.itcast.oa.dao.IUserDao;
import cn.itcast.oa.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{


}
