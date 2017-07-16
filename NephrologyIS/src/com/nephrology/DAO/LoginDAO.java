package com.nephrology.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.LoginBean;

public class LoginDAO {
	Boolean validated = false;
	SessionFactory factory;
	Session session;
	Transaction transaction = null;
	LoginBean lb = new LoginBean();
	
	public Boolean validateUser(LoginBean loginbean){
		
		factory = HibernateUtilities.getSessionFactory();
		System.out.println(factory);
		session = factory.openSession();
		System.out.println("session opend");
		
		
		try{
			
			transaction = session.beginTransaction();
			lb = (LoginBean) session.get(LoginBean.class, loginbean.getUserName());
			transaction.commit();
			if(lb != null && lb.getPassword().equals(loginbean.getPassword())){
				loginbean.setDocID(lb.getDocID());
				validated = true;
			}
			
			
		}catch(HibernateException e){
			if(transaction != null){
				transaction.rollback();
			}
		}finally{
			session.close();
		}
		
		
		return validated;
		
	}

}
