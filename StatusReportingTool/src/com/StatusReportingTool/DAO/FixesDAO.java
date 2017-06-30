package com.StatusReportingTool.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.StatusReportingTool.Bean.FixesBean;
import com.StatusReportingTool.Bean.ReleaseBean;
import com.StatusReportingTool.HibernateUtilities.HibernateUtilities;

public class FixesDAO {
	SessionFactory factory;
	Session session;
	Transaction tx;
	ArrayList<FixesBean> fixesList = new ArrayList<FixesBean>();
	
	
	public ArrayList<FixesBean> viewFixes(FixesBean fixesBean){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			Criteria cs = session.createCriteria(FixesBean.class);
			fixesList = (ArrayList<FixesBean>) cs.list();
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			}			
		}finally{
			session.close();
		}
		return fixesList;
		
	}
	
	public ArrayList<FixesBean> releaseFixes(List<String> fnfId){
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		try{
			tx = session.beginTransaction();
			for(int i = 0; i < fnfId.size(); i++){
				FixesBean bean = new FixesBean();
				bean = (FixesBean) session.get(FixesBean.class,fnfId.get(i) );
				fixesList.add(bean);
			}
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			}			
		}finally{
			session.close();
		}
		
		return fixesList;
		
	}

}
