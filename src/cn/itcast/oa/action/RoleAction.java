package cn.itcast.oa.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import antlr.Utils;
import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
import utils.DepartmentUtils;
import utils.PrivilegeUtils;

/**
 * 岗位action
 * @author admin
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	private Long[] privilegeIds;
	/*
	 * 查询岗位列表
	 */
	public String list(){
	List<Role> list=roleService.findAll();
	ValueStack vs=getValueStack();
	vs.set("list", list);
	return "list";
	}
	/*
	 * 根据id删除岗位
	 */
	public String delete(){
		roleService.delete(model);
		return "toList";
	}
	/*
	 * 跳转到修改页面
	 */
	public String editUI(){
		Role role=roleService.findById(model.getId());
		getValueStack().push(role);
		return "editUI";
	}
	/*
	 * 修改岗位信息
	 */
	public String edit(){
		Role role=roleService.findById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
	/*
	 * 添加薪职位
	 */
	public String addUI(){
		return "addUI";
	}
	/*
	 * 增加新岗位
	 */
	public String add(){
		roleService.save(model);
		return "toList";
	}
	/*
	 * 跳转到设置权限界面
	 */
	public String setPrivilegeUI(){
		//获取要设置权限的role  用于回显数据
		Role role=roleService.findById(model.getId());
		getValueStack().push(role);
		//List<Privilege> priList=privilegeService.findAll();
		List<Privilege> privilegeList = privilegeService.findTopList();//查询顶级权限
		getValueStack().set("privilegeList", privilegeList);
		List<Privilege> treeList=PrivilegeUtils.getTreeList(privilegeList, null);
		getValueStack().set("treeList",treeList);
		return "setPrivilegeUI";
	}
	/*
	 *为role设置权限
	 */
	public String setPrivilege(){
		Role role=roleService.findById(model.getId());
		if(privilegeIds!=null&&privilegeIds.length>0){
			List<Privilege> priList=privilegeService.findByIds(privilegeIds);
			role.setPrivileges(new HashSet<Privilege>(priList));
		}else{
			role.setPrivileges(null);
		}
		return "toList";
	}
}	
