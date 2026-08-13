package com.example.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        if(token == null || !token.equals("12345")){
            //not authenticated
            httpServletResponse.setStatus(401);
            httpServletResponse.setContentType("application/json");

            httpServletResponse.getWriter().write(
                    "{\"message\":\"Authentication is required\"}"
            );
            return;
        }

        chain.doFilter(request,response);
    }
}

//ContentCacheResponseWrapper