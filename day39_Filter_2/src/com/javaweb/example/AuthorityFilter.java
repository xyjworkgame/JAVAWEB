package com.javaweb.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthorityFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
						 HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
//		- 获取 servletPath, 类似于 /app_3/article1.jsp
		String servletPath = request.getServletPath();

		//不需要被拦截的 url 列表.
		List<String> uncheckedUrls = Arrays.asList("/403.jsp", "/articles.jsp",
				"/authority-manager.jsp", "/login.jsp", "/logout.jsp");

		if(uncheckedUrls.contains(servletPath)){
			filterChain.doFilter(request, response);
			return;
		}

//		- 在用户已经登录(可使用 用户是否登录 的过滤器)的情况下, 获取用户信息. session.getAttribute("user")
		User user = (User)request.getSession().getAttribute("user");
		if(user == null){
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

//		- 再获取用户所具有的权限的信息: List<Authority>
		List<Authority> authorities = user.getAuthorities();

		// - 检验用户是否有请求 servletPath 的权限: 可以思考除了遍历以外, 有没有更好的实现方式
		Authority authority = new Authority(null, servletPath);
		// - 若有权限则: 响应
		if (authorities.contains(authority)) {
			filterChain.doFilter(request, response);
			return;
		}

//		- 若没有权限: 重定向到 403.jsp
		response.sendRedirect(request.getContextPath() + "/403.jsp");
		return;
	}


}
