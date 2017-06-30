package com.StatusReportingTool.DAO;

import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





import com.StatusReportingTool.Bean.ReportBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;
	/**
	 * LoginDAO.java
	 * Purpose: Getting Data from database to validate the user.
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ReportDAO {
private SessionFactory factory;
	
	private Session session;
	private Transaction tx;
	
	@SuppressWarnings("deprecation")
	/**
	 * Adding Report in text format
	 *
	 * @return ReportBean.
	 * @exception HibernateException
	 */
	public boolean addReport(ReportBean rb) throws SQLException{
		
		factory = HibernateUtilities.getSessionFactory();		
		session = factory.openSession();
		rb.setFile(Hibernate.createBlob(rb.getTxtFile(),session));	// Converting byte file to blob
		tx = null;
		
		try{
			tx = session.beginTransaction();			
			session.saveOrUpdate(rb); //Saving the Date and text file in database		 	
			tx.commit();		
			return true;
		}/*If any Hibernate exception is thrown*/	
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
