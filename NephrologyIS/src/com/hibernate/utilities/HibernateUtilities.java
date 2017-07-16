package com.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {
	public static SessionFactory factory;

	private HibernateUtilities(){
		
	}
	public static SessionFactory getSessionFactory(){
		if(factory==null){
		
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		System.out.println("Hi from Hib");
		return factory;
	}
}
