package cn.itcast.oa.action;

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
		User list=userService.findById(model.getId());
		getValueStack().push(list);
		return "editUI";
	}
	//修改
	public String edit(){
		return null;
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
		return null;
	}
	public String delete(){
		userService.delete(model);
		return "toList";
	}
}
