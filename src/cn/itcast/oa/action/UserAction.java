package cn.itcast.oa.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.domain.User;
import cn.itcast.oa.service.IUserService;
import utils.DepartmentUtils;
import utils.MD5Utils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	private Long departmentId;//属性驱动，部门id
	private Long[] roleIds;//属性驱动，岗位id
	//遍历所有user
	public String list(){
		List<User> users=userService.findAll();
		for(User u:users){
			System.out.println(u.getName());
		}
		getValueStack().set("userList", users);
		return "list";
	}
	//跳转到修改页面
	public String editUI(){
		User user=userService.findById(model.getId());
		getValueStack().push(user);
		List<Department> topList=departmentService.findTopList();
		List<Department> treeList=DepartmentUtils.getTreeList(topList, null);
		getValueStack().set("treeList", treeList);
		List<Role> roleList=roleService.findAll();
		getValueStack().set("roleList", roleList);
		return "editUI";
	}
	//修改
	public String edit(){
		if(departmentId!=null){
			Department d=departmentService.findById(departmentId);
			model.setDepartment(d);
		}else{
			model.setDepartment(null);
		}
		if(roleIds!=null&&roleIds.length>0){
			//因为一个用户可以拥有多个职位  所以这里我们用一个数组装职位的id  可以同时设置多个职位给user
			List<Role> role=roleService.findByIds(roleIds);
			model.setRoles(new HashSet<Role>(role));
		}else{
			model.setRoles(null);
		}
		userService.update(model);
		return "toList";
	}
	//跳转到增加页面
	public String addUI(){
		List<Department> topList=departmentService.findTopList();
		List<Department> treeList=DepartmentUtils.getTreeList(topList, null);
		List<Role> roleList = roleService.findAll();
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		return "addUI";
	}
	//添加user'
	public String add(){
		if(departmentId!=null){
			Department d=departmentService.findById(departmentId);
			model.setDepartment(d);
		}
		if(roleIds!=null&&roleIds.length>0){
			List<Role> role=roleService.findByIds(roleIds);
			model.setRoles(new HashSet<Role>(role));
		}
		userService.save(model);
		return "toList";
	}
	//删除user
	public String delete(){
		userService.delete(model);
		return "toList";
	}
	public String initPassword(){
		User user=userService.findById(model.getId());
		user.setPassword(MD5Utils.md5("1234"));
		userService.update(user);
		return "toList";
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	
}
