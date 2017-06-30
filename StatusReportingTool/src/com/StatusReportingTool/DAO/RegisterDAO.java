package com.StatusReportingTool.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.StatusReportingTool.Bean.RegisterBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;
	
	/**
	 * LoginDAO.java
	 * Purpose: Setting Data to database from form.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */

public class RegisterDAO {
private SessionFactory factory;
	
	private Session session;
	private Transaction tx;
	
	/**
	 * Selecting the row which contains users userID
	 *
	 * @return RegisterBean.
	 * @exception HibernateException
	 */
	public boolean addNewUser(RegisterBean rb){
		
		factory = HibernateUtilities.getSessionFactory(); //getting sessionFactory from singleton class		
		session = factory.openSession(); //getting session from sessionFactory
		tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(rb); // adding new row in database			
			tx.commit();
			
			return true;
		} /*If any Hibernate exception is thrown*/
		catch(HibernateException e){
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
