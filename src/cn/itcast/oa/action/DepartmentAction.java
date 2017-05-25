package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;//属性驱动
	/*
	 * 遍历所有部门
	 */
	public String list(){
		List<Department> list=departmentService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	/*
	 * 转到新建部门页面
	 */
	public String addUI(){
		List<Department> list = departmentService.findAll();
		getValueStack().set("departmentList", list);
		return "addUI";
	}
	/*
	 * 新建部门
	 */
	public String add(){
		departmentService.save(model);
		return "toList";
	}
	/*
	 * 跳转到修改页面
	 */
	public String editUI(){
		//准备数据：部门列表
				List<Department> list = departmentService.findAll();
				
				//准备数据：要修改的部门
				Department dept = departmentService.findById(model.getId());
				
				getValueStack().set("departmentList", list);
				getValueStack().push(dept);
				
				if(dept.getParent() != null){
					parentId = dept.getParent().getId();//设置parentId的值，用于回显
				}
		return "editUI";
	}
}
