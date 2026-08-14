package com.example.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                      HttpServletResponse response,
                      Object handler) throws IOException {
        String userRole = request.getHeader("x-user-role");
        if(userRole == null || !userRole.equals("admin")){
            response.setStatus(403);
            response.getWriter().write("You are not authorized for this action");

            return false;
        }
        return true;
    }
}
