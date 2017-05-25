package cn.itcast.oa.action;

import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Book;
@Controller
public class BookAction extends BaseAction<Book>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String execute(){
		System.out.println(model);
		bookService.save(model);
		return NONE;
		
	}

}
