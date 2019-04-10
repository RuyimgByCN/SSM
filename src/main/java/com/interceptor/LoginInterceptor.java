package com.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 如果返回true
	 * 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("调用");
		String uri = request.getRequestURI();
		if (uri.indexOf("user/login2.mvc") != -1) {
			System.out.println("11");
			return true;
		}else {
			System.out.println("22");
		User user = (User) request.getSession().getAttribute("loginuser");
		System.out.println(user);
		if (user != null) {
			return true;
		} else {
			request.getSession().setAttribute("msg", "请去登录");
			response.sendRedirect("../login.jsp");
			//request.getRequestDispatcher("../login.jsp").forward(request, response);
			return false;
		}
		}
//		if(user == null){
//			response.sendRedirect("login.jsp");
//		}
//		//true放行,false拦截
//		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle(), 在访问Controller之后，访问视图之前被调用,这里可以注入一个时间到modelAndView中，用于后续视图显示");
    	modelAndView.addObject("date","由拦截器生成的时间:" + new Date());

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 System.out.println("afterCompletion(), 在访问视图之后被调用");  

	}

}
