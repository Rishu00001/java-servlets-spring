package com.example.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        Long startTime = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestId = UUID.randomUUID().toString();
        //Assign an unique request id to the request
        res.setHeader("X-Request-ID",requestId);
        System.out.println("Incoming request "+ req.getMethod() + req.getRequestURI());
        chain.doFilter(request,response);
        Long duration = System.currentTimeMillis() - startTime;
        System.out.println("Response status" + res.getStatus());
        System.out.println("Api response time " + duration);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
