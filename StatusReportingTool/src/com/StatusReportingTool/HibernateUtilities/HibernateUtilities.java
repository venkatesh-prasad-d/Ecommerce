package com.StatusReportingTool.HibernateUtilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtilities.java
 * Purpose: Singleton class to create sessionFactory.
 *
 * @author Venkatesh Prasad D
 * @version 1.0 6/18/2017
 */

public class HibernateUtilities {

	public static SessionFactory factory;
	
	private HibernateUtilities(){
		
	}
	/**
	 * Static method to return SessionFactory object
	 *
	 * @return Error.
	 */
	public static synchronized SessionFactory getSessionFactory(){
		if(factory==null){ // Checking whether SessionFactory object is already present
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); // Creating based on configuration file
		}
		return factory;		
	}
}
