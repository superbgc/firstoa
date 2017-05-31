package cn.itcast.oa.action;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
import utils.DepartmentUtils;
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;//属性驱动
	/**
	 * 查询部门列表
	 */
	public String list(){
		//List<Department> list = departmentService.findAll();
		List<Department> list = null;
		if(parentId == null){
			//查询顶级部门列表
			list = departmentService.findTopList();
		}else{
			//查询子部门列表
			list = departmentService.findChildList(parentId);
			System.out.println(list);
			
			Department dept = departmentService.findById(parentId);
			getValueStack().set("dept", dept);
		}
		
		getValueStack().set("list", list);
		return "list";
	}

	/**
	 * 根据id删除部门
	 */
	public String delete(){
		departmentService.delete(model);
		return "toList";
	}
	
	/**
	 * 跳转到部门添加页面
	 */
	public String addUI(){
		//准备部门列表数据，用于select框显示
		//List<Department> list = departmentService.findAll();
		//showTree(list,"");
		List<Department> topList = departmentService.findTopList();//所有顶级部门列表
		List<Department> treeList = DepartmentUtils.getTreeList(topList,null);
		for(Department d:treeList){
			System.out.println(d.getName());
		}
		getValueStack().set("departmentList", treeList);
		
		return "addUI";
	
	}
	
	/**
	 * 添加部门
	 */
	public String add(){
		if(parentId != null){
			Department parent = departmentService.findById(parentId);
			model.setParent(parent);//设置上级部门
		}else{
			model.setParent(null);
		}
		System.out.println(departmentService.findByName(model.getName())+"111111111111111");
		if(departmentService.findByName(model.getName())==null){
			departmentService.save(model);
			return "toList";
		}else{
			return "error";
		}
		
		
		
	}
	
	/**
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

	/**
	 *	修改部门 
	 */
	public String edit(){
		//先查询再修改
		Department dept = departmentService.findById(model.getId());
		
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		
		if(parentId != null){
			Department parent = departmentService.findById(parentId);
			dept.setParent(parent);//设置上级部门
		}else{
			dept.setParent(null);
		}
		
		departmentService.update(dept);
		
		return "toList";
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}
	public void showTree(Collection<Department> d,String prefix){
		
		for(Department a:d){
			model.setName(a.getName()+prefix);
			Set<Department> c=a.getChildren();
			showTree(c,"  "+prefix);
		}
	}
}

