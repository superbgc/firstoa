package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.oa.service.IBookService;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	@Resource
	protected IBookService bookService;
	//在构造方法中获得model类型
	public BaseAction(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();//父类型action
		Type[]types=type.getActualTypeArguments();
		Class<T>clazz=(Class<T>)types[0];
		try {
			model=clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected T model;
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
}
