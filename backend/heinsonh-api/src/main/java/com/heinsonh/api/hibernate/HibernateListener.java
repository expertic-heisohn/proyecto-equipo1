package com.heinsonh.api.hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

@WebListener
public class HibernateListener implements ServletContextListener{
	
			 public void contextInitialized(ServletContextEvent sce) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			}

			public void contextDestroyed(ServletContextEvent sce) {
				// TODO Auto-generated method stub
				
			}
}
