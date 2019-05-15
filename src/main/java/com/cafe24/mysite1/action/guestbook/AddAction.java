package com.cafe24.mysite1.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite1.dao.GuestBookDao;
import com.cafe24.mysite1.vo.GuestbookVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setContents(contents);
		vo.setPassword(password);

		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);
		WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");
	}

}
