package com.nephrology.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.SearchBean;
import com.nephrology.bean.SearchOGBean;

public class SearchOnGoing {
	ArrayList<SearchOGBean> searchlist =new ArrayList<SearchOGBean>();
	SessionFactory factory;
	Session session;
	Criteria cs;
	Transaction tx;
	int c = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayList<SearchOGBean> getData(SearchOGBean sb){
		System.out.println();
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			cs = session.createCriteria(SearchOGBean.class);
			cs.add(Restrictions.ilike("patientId",sb.getPatientId()));
			c++;
			System.out.println(cs+" "+c);
			searchlist = (ArrayList<SearchOGBean>) cs.list();
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
