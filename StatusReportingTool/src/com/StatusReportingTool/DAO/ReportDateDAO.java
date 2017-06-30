package com.StatusReportingTool.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.StatusReportingTool.Bean.ReportDateBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;
	/**
	 * ReportDateDAO.java
	 * Purpose: Getting Date from database for the uploaded dates .
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ReportDateDAO {
	SessionFactory factory;
	Session session; 
	Transaction tx;
	ArrayList<ReportDateBean> dateList;
	
		/**
		 * Getting Report date
		 *
		 * @return arraylist of ReportBean.
		 * @exception HibernateException
		 */
	public ArrayList<ReportDateBean> getDates(ReportDateBean dateBean){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		Criteria cs = session.createCriteria(ReportDateBean.class);
		cs.add(Restrictions.ilike("emp_id", dateBean.getEmp_id())); //Adding Restriction to search only for the employee id
				
		try{
			tx = session.beginTransaction();
					
			dateList =  (ArrayList<ReportDateBean>) cs.list(); //Getting the list of bean objects
			tx.commit();
			System.out.println("tx saved");
			
		}/*If any Hibernate exception is thrown*/	
		catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			
			}
			
		}
		finally{
			session.close();
		}
		
		return dateList;
		
	}

}
