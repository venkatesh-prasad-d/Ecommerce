package com.nephrology.DAO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.SearchBean;
import com.nephrology.bean.SearchOGBean;

public class SearchHistorical {

	ArrayList<SearchBean> searchlist =new ArrayList<SearchBean>();
	SessionFactory factory;
	Session session;
	Criteria cs;
	Transaction tx;
	
	public ArrayList<SearchBean> getALLData(SearchBean sb){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			cs = session.createCriteria(SearchBean.class);
			cs.add(Restrictions.ilike("patientId",sb.getPatientId()));
			System.out.println(cs);
			searchlist = (ArrayList<SearchBean>) cs.list();
			tx.commit();
			
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
			System.out.println(e);
			
		}finally{
			session.close();
			
		}
		return searchlist;
		
	}
	
	public ArrayList<SearchBean> getSpecificData(SearchBean sb,Timestamp sDate,Timestamp eDate){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		System.out.println(sDate+" "+eDate);
		tx = null;
		
		try{
			tx = session.beginTransaction();
			Criterion idCriteria = Restrictions.ilike("patientId", sb.getPatientId());
			Criterion dates = Restrictions.between("sqlDate", sDate, eDate);
			Conjunction andOp = Restrictions.conjunction();
			andOp.add(idCriteria);
			andOp.add(dates);
			Criteria cs = session.createCriteria(SearchBean.class);
			cs.add(andOp);
			System.out.println(cs);
			searchlist = (ArrayList<SearchBean>) cs.list();
			System.out.println(searchlist.size()+"size");
			tx.commit();
			
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
			System.out.println(e);
			
		}finally{
			session.close();
			
		}
		
		return searchlist;
		
	}
}
