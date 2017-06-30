package com.StatusReportingTool.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.StatusReportingTool.Bean.LoginBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;

	/**
	 * LoginDAO.java
	 * Purpose: Getting Data from database to validate the user.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
		
	public class LoginDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction tx;
	
	/**
	 * Selecting the row which contains users userID
	 *
	 * @return LoginBean.
	 * @exception HibernateException
	 */

	public LoginBean validate(LoginBean lb){
		LoginBean bean = new LoginBean();
		factory = HibernateUtilities.getSessionFactory(); //getting sessionFactory from singleton class
		session = factory.openSession(); //getting session from sessionFactory
		tx = null;
		bean.setValid(false);
		
		try{
			tx = session.beginTransaction(); // starting Transaction
			bean = (LoginBean) session.get(LoginBean.class, lb.getUname()); //Selecting the row which contains users userID
			tx.commit(); // Commiting the transaction
				System.out.println(bean+"bean");
				if(bean == null){ // checking whether user is present are no
					lb.setValid(false);
					return lb;
				}
				else if(bean.getPass().equals(lb.getPass())){ //If data in database is same as input data then validate
					bean.setValid(true);
					return bean;
				}
				else{ //Else return invalid
					bean.setValid(false);
					return bean;
				}
				
								
			/*If any Hibernate exception is thrown*/	
		}catch(HibernateException e){
			if(tx != null){ // If transaction has started close the transaction
				System.out.println(e);
				tx.rollback();			
		}
		}
			finally{
			session.close(); // closing the session
		}
		return bean;
		
			
		}
}
