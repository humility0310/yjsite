package com.yj.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yj.yjsite.service.UsersService;
import com.yj.yjsite.vo.UsersVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// Web Application Context 받아오기
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		// Container 안에 있는 UserService Bean(객체) 받아오기
		UsersService userService = ac.getBean(UsersService.class);

		UsersVo vo = new UsersVo();
		vo.setId(id);
		vo.setPassword(password);

		UsersVo usersVo = userService.login(vo);
		//System.out.println("usersVo.getUsersImage() = " + usersVo.getUsersImage());
		if (usersVo == null) {
			response.sendRedirect(request.getContextPath() + "/login?result=fail");
			return false;
		}

		// 인증
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", usersVo);
		response.sendRedirect(request.getContextPath());

		return false;
	}

}
