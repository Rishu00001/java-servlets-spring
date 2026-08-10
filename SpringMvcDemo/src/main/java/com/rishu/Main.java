package com.rishu;


import com.rishu.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addContext(contextPath,baseDoc);

        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();
        springContext.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        Tomcat.addServlet(
                context,"dispatcherServlet",dispatcherServlet
        );
        context.addServletMappingDecoded("/","dispatcherServlet");

        tomcat.start();
        System.out.println("Tomcat started");
        tomcat.getServer().await();
    }
}