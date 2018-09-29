package com.mmall.common.method;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossFilter extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		
		//StringBuffer stringBuffer = request.getRequestURL();
		
//		 if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
	            // CORS "pre-flight" request
	            response.addHeader("Access-Control-Allow-Origin", "*");
	            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	            response.addHeader("Access-Control-Allow-Headers", "Content-Type,x-requested-with,Authorization,AUTH_ID,Origin,X-Powered-By");
	            response.addHeader("Access-Control-Max-Age", "1800");//30 min
//	        }
	        filterChain.doFilter(request, response);
	}
	
}
