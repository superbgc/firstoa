package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Department;

public interface IDepartmentService {

	List<Department> findAll();

	void save(Department department);

	Department findById(Long id);

	void delete(Department department);

	void update(Department dept);

	List<Department> findTopList();

	List<Department> findChildList(Long parentId);

	List<Department> findByName(String name);

}
