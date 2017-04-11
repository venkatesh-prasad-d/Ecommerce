package com.patchingplanner.DAO;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.patchingplanner.HibernateUtil.HibernateUtilities;
import com.patchinplanner.bean.ServerBean;

public class SearchDAO {
	
	private SessionFactory factory;
	private Session session;
	private Transaction tx = null;
	ArrayList<ServerBean> arr = new ArrayList<ServerBean>();
	private String[] servers;
	private ServerBean sb1 = new ServerBean();
	String s;
	
		public ArrayList<ServerBean> getServers(String list){
			
			
				
				factory = HibernateUtilities.getSessionFactory();
				session = factory.openSession();
				
				try{
					servers =list.split(","); 
					for(int i = 0; i < servers.length; i++){
						
						s = servers[i].trim();
						tx = session.beginTransaction();
						sb1 = (ServerBean) session.get(ServerBean.class,s);
						arr.add(sb1);
						tx.commit();
						
					}
								
				}catch(HibernateException e){
					if(tx != null){
						System.out.println(e);
						tx.rollback();
					}
					
				}finally{
					session.close();
				}
			
			return arr;
			
		}

}
