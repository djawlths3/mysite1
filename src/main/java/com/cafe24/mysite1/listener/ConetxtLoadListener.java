package com.cafe24.mysite1.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ConetxtLoadListener
 *
 */
@WebListener
public class ConetxtLoadListener implements ServletContextListener {

    
    public ConetxtLoadListener() {
    
        System.out.println("container starts...");
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
      
    }


    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	String context = servletContextEvent.getServletContext().getInitParameter("contextConfigLocation");
    	System.out.println(context);
    }
	
}
