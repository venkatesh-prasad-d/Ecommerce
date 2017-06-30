package com.StatusReportingTool.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.StatusReportingTool.Bean.ReportDateBean;
import com.StatusReportingTool.Bean.ViewReportBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;
	/**
	 * ReportDateDAO.java
	 * Purpose: Getting Date from database for the uploaded dates .
	 *
	 * @author Venkatesh Prasad D
	 * @version 1.0 6/18/2017
	 */
public class ViewReportDAO {
	SessionFactory factory;
	Session session; 
	Transaction tx;
	ViewReportBean vb = new ViewReportBean();;
	
	/**
	 * Getting Report for the selected date
	 *
	 * @return ViewReportBean.
	 * @exception HibernateException
	 */
	
	public ViewReportBean getReport(ViewReportBean viewBean){
		
		vb.setWeek(viewBean.getWeek());;
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		System.out.println(viewBean.getEmp_id());
		System.out.println(viewBean.getStartDate());
		Criterion idEmp = Restrictions.ilike("emp_id", viewBean.getEmp_id());  //Adding Restriction to search only for the employee id
		Criterion startRes = Restrictions.like("startDate", viewBean.getStartDate());  //Adding Restriction to search only for Selected Date
		Conjunction addConjunction = Restrictions.conjunction(); // AND Operator(Conjunction)
		addConjunction.add(idEmp); // AND ing both Restriction
		addConjunction.add(startRes);
		Criteria cs = session.createCriteria(ViewReportBean.class); // Creating Citeria for the Entity Class
		cs.add(addConjunction);  // Adding AND Operator for the citeria
		
		try{
			tx = session.beginTransaction();			
			viewBean =  (ViewReportBean) cs.uniqueResult(); //Getting Only one unique result for the query
			tx.commit();
			
			
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
		viewBean.setWeek(vb.getWeek());
		return viewBean;
		
	}
	
	

}
