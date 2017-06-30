package com.StatusReportingTool.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.StatusReportingTool.Bean.ReleaseBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;

public class ReleaseDAO {
	SessionFactory factory;
	Session session;
	Transaction tx;
	ArrayList<ReleaseBean> releaseList = new ArrayList<ReleaseBean>();
	
	public ArrayList<ReleaseBean> getReleaseList(ReleaseBean releaseBean){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			Criteria cs = session.createCriteria(ReleaseBean.class);
			cs.add(	Restrictions.ilike("releaseID", releaseBean.getReleaseID()));
			releaseList = (ArrayList<ReleaseBean>) cs.list();
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			}			
		}finally{
			session.close();
		}
		
		return releaseList;
		
	}
	
	public void addRelease(ArrayList<ReleaseBean> releaseList){
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			for(int i = 0; i < releaseList.size(); i++){
			session.saveOrUpdate(releaseList.get(i));
			}
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			}			
		}finally{
			session.close();
		}
		
	}
	

}
