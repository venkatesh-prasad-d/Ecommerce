package com.patchingplanner.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.patchingplanner.HibernateUtil.HibernateUtilities;

import com.patchinplanner.bean.RegisterBean;

public class RegisterDAO {
	private SessionFactory factory;
	
	private Session session;
	private Transaction tx;
	
	public boolean addNewUser(RegisterBean rb){
		System.out.println("Hi from DAO b4");
		factory = HibernateUtilities.getSessionFactory();
		
		session = factory.openSession();
		tx = null;
		System.out.println("Hi from DAO");
		try{
			tx = session.beginTransaction();
			System.out.println("transaction started");
			System.out.println(rb.getUid()+rb.getName()+rb.getPass());
			session.saveOrUpdate(rb);
			
			System.out.println("object added");
			tx.commit();
			System.out.println("tx saved");
			return true;
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			
			}
			return false;
		}
		finally{
			session.close();
		}
		
		
	}

}
