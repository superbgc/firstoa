package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Privilege;

public interface IPrivilegeService{

	List<Privilege> findTopList();

	List<Privilege> findByIds(Long[] privilegeIds);

	List<Privilege> findAll();

}
