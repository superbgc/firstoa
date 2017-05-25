package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Role;

/**
 * 岗位action
 * @author admin
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
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
	 * 增加岗位role
	 */
	public String add(){
		roleService.save(model);
		return "toList";
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
		Role role=roleService.getById(model.getId());
		getValueStack().push(role);
		return "editUI";
	}
	/*
	 * 修改岗位信息
	 */
	public String edit(){
		Role role=roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		roleService.update(role);
		return "toList";
	}
}	
