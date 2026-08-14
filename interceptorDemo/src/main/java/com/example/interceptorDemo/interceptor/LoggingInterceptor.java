package com.example.interceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){
        System.out.println("--Incoming request--");
        System.out.println("HTTP method: "+request.getMethod());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Request Paramaters: "+request.getQueryString());
        System.out.println("Client IP: "+ request.getRemoteAddr());
        System.out.println("Token : "+ request.getHeader("token"));
        if (handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            System.out.println("Controller : "+ method.getBeanType().getName());
            System.out.println("Controller Method : "+ method.getMethod().getName());
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex){
        System.out.println("Response Status: "+response.getStatus());
    }

}
