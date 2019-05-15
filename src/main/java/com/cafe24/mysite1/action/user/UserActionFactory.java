package com.cafe24.mysite1.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite1.action.main.MainAction;
import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if("join".equals(actionName)) {
			action = new JoinAction();
		} else if("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();
		} else if("loginform".equals(actionName)) {
			action = new LoginFormAction();
		} else if("login".equals(actionName)) {
			action = new LoginAction();
		} else if("logoutform".equals(actionName)) {
			action = new LogoutAction();
		} else if("updateform".equals(actionName)) {
			action = new UpdateFormAction();
		} else {
			action = new MainAction();
		}
		
		return action;
	}

	

}
