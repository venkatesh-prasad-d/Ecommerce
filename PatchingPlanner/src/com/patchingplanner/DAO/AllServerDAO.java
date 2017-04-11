package com.patchingplanner.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.patchingplanner.HibernateUtil.HibernateUtilities;
import com.patchinplanner.bean.ServerBean;

public class AllServerDAO {
	
	private SessionFactory factory ;
	private Session session;
	private Transaction tx = null;
	ArrayList<ServerBean> array = new ArrayList<ServerBean>();
	
	@SuppressWarnings("unchecked")
	public ArrayList<ServerBean> getServer(ServerBean sb){
		
		factory = HibernateUtilities.getSessionFactory();
		session = factory.openSession();
		
		try{
			tx = session.beginTransaction();
		
			if(sb.getCategory().equals("ALL")){
				sb.setCategory("%");
			}
		
			Criteria cs = session.createCriteria(ServerBean.class);
			System.out.println(sb.getCategory());
			cs.add(Restrictions.ilike("category",sb.getCategory()));
			cs.addOrder(Order.asc("category"));
			cs.addOrder(Order.asc("environment"));
			cs.addOrder(Order.asc("type"));
			array = (ArrayList<ServerBean>) cs.list();
			tx.commit();
			//array.add(sb);
			try{
				
			System.out.println(array.size());
			}catch(Exception e){
				System.out.println(e);
			}
			
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
