package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cn.itcast.oa.service.IBookService;
import cn.itcast.oa.service.IRoleService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	
	protected T model;

	//在构造方法中获得model类型
	public BaseAction(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//父类型action
		Type[]types=type.getActualTypeArguments();
		//获取当前的实体类是谁 clazz
		Class<T> clazz=(Class<T>)types[0];
		try {
			//动态的实例化当前实体类 clazz.newInstance();
			//所以任何action继承baseAction将通过传入的实体类型获取相应实体对象为model
			model=clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	/**
	 * 获得值栈
	 *
	 */
	protected ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
}
