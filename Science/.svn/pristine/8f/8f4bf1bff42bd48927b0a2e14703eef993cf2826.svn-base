package com.fujitsu.ttf.yd.shiro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fujitsu.ttf.yd.utils.TokenUtil;


public class AuthenticationInterceptor implements HandlerInterceptor {

	
    public AuthenticationInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization");
        String openId = TokenUtil.parse(token);
        request.setAttribute("X-LOGINID", openId);
        return true;
    }

}
