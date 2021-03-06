package cn.itcast.oa.base;

import java.util.List;

import cn.itcast.oa.domain.Department;

/**
 * 通用Dao接口
 * @author zhaoqx
 *
 */
public interface IBaseDao<T> {
	/**
	 * 添加
	 */
	public void save(T entity);
	
	/**
	 * 根据id删除
	 * @return 
	 */
	public void delete(Long id);
	
	/**
	 * 根据id修改
	 */
	public void update(T entity);
	
	/**
	 * 根据id查询
	 */
	public T findById(Long id);
	
	/**
	 * 一次查询多个对象
	 */
	public List<T> findByIds(Long[] ids);
	
	/**
	 * 查询所有
	 */
	public List<T> findAll();
}
