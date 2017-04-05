package com.patchingplanner.DAO;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.patchingplanner.HibernateUtil.HibernateUtilities;
import com.patchinplanner.bean.ServerBean;

public class AllServerDAO {
	
	private SessionFactory factory ;
	private Session session;
	private Transaction tx = null;
	ArrayList<ServerBean> array = new ArrayList<ServerBean>();
	
	public ArrayList<ServerBean> getServer(ServerBean sb){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		
		try{
			tx = session.beginTransaction();
		
			if(sb.getCategory().equals("ALL")){
				sb.setCategory("%");
			}
			String s = sb.getCategory();
			System.out.println(s);
			array = (ArrayList<ServerBean>) session.get(ServerBean.class, s);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx != null){
				System.out.println(e);
				tx.rollback();
			}
			
		}finally{
			session.close();
		}
				
		
		return array;
		
	}
}
