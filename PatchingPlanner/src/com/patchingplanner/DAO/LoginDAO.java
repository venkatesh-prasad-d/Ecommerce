package com.patchingplanner.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.patchingplanner.HibernateUtil.HibernateUtilities;
import com.patchinplanner.bean.LoginBean;

public class LoginDAO {
	private SessionFactory factory;
	private Session session;
	private Transaction tx;

	public boolean validate(LoginBean lb){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		tx = null;
		
		try{
			tx = session.beginTransaction();
			LoginBean bean = (LoginBean) session.get(LoginBean.class, lb.getUname());
			tx.commit();
				
				if(bean.getPass().equals(lb.getPass())){
					return true;
				}
								
				
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();			
		}
		}
			finally{
			session.close();
		}
		return false;
		
			
		}
}

