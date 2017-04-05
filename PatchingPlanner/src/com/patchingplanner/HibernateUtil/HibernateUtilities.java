package com.patchingplanner.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

	public static SessionFactory factory;
	
	private HibernateUtilities(){
		
	}
	
	public static synchronized SessionFactory getSessionFactory(){
		if(factory==null){
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;		
	}
}
