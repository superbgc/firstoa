package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Role;

public interface IRoleService {
	/**
	 * 添加
	 */
	public void save(Role role);
	
	/**
	 * 根据id删除
	 */
	public void delete(Role model);
	
	/**
	 * 根据id修改
	 */
	public void update(Role role);
	
	/**
	 * 根据id查询
	 */
	public Role getById(Long id);
	
	/**
	 * 一次查询多个对象
	 */
	public List<Role> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 */
	public List<Role> findAll();
}
