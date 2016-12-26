package com.yj.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yj.yjsite.vo.UsersVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 1. handler 종류
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		// 2, @Auth 붙은지 확인
		Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		if (auth == null) {
			return true;
		}

		// 3, 접근제어 (세션값 없으니 로그인폼 이동)
		HttpSession session = request.getSession();
		System.out.println("session = " + session);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}

		//담아보니 없엉(매칭 X)
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		System.out.println("authUser = " + authUser);
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}
