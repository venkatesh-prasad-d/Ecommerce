package com.nephrology.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.RegisterBean;

public class RegisterDAO {
	SessionFactory factory;
	Session session;
	public boolean registerUser(RegisterBean registerbean){
		Boolean addUser = false;
		
		 factory = HibernateUtilities.getSessionFactory();
		 System.out.println(factory);
		 session = factory.openSession();
		 
		Transaction tx = null;
		
		try{
		tx = session.beginTransaction();
		session.saveOrUpdate(registerbean);
		System.out.println("User added succefully");
		tx.commit();
		addUser = true;
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
		return addUser;
	}

}
