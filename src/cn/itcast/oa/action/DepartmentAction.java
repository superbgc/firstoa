package cn.itcast.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;
@Controller
@Scope("prototype")
@SuppressWarnings("unchecked")
public class DepartmentAction extends BaseAction<Department> {
	private Long parentId;//属性驱动 当表单提交到对应的action上时  会自动根据名字复制在这个属性驱动上
	/*
	 * 遍历最上级部门
	 */
	List<Department> list=null;
	public String list(){
		if(parentId==null){
			list=departmentService.findTopList();
			getValueStack().set("list", list);
		}else{
			list=departmentService.findChildList(parentId);
			getValueStack().set("list", list);
			System.out.println(list+"1111111111111111111");
		}
		
		return "list";
	}
	/*
	 * 删除部门
	 */
	public String delete(){
		departmentService.delete(model.getId());
		return "toList";
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
		//说明这个预见部门有上级部门
		if(parentId!=null){
			//查到这个上级部门
			Department department=departmentService.findById(parentId);
			model.setParent(department);
			departmentService.save(model);
		}else{
			//表示该预设部门是顶级部门 没有什么上级
			departmentService.save(model);
		}
		return "toList";
	}
	/*
	 * 跳转到修改页面
	 */
	public String editUI(){
				//修改涉及到修改上级部门  所以我们需要获取所有部门   用于下拉选中的数据
				List<Department> list = departmentService.findAll();
				
				//准备数据：要修改的部门 
				Department dept = departmentService.findById(model.getId());
				
				getValueStack().set("departmentList", list);
				getValueStack().push(dept);
				if(dept.getParent() != null){
					setParentId(dept.getParent().getId());//设置parentId的值，用于回显
				}
		return "editUI";
	}
	/*
	 * 修改部门
	 */
	public String edit(){
		//查询所有部门  让我们可以选择要新建的部门的上级部门是谁
		List<Department> list=departmentService.findAll();
		//根据我们选中的部门的id查到当前的实体（当前的部门信息）
		Department dept =departmentService.findById(model.getId());
		//进行修改信息
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		//更新数据库中的 数据
		departmentService.update(dept);
		return "toList";
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
