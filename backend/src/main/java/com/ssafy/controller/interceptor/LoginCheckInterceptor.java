package com.ssafy.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.model.dto.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		if(request.getMethod().equalsIgnoreCase("options"))
			return true;
		HttpSession session = request.getSession();
		log.info(session.toString());
		UserInfo user =(UserInfo)session.getAttribute("user");
		if(user == null){
			log.info("로그인 안된 상태~~");
			response.setStatus(401);
			return false;
		}
		return true;
	}
}
