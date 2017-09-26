package com.patchingscheduler.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.patchingscheduler.model.ServerBean;

@Repository
@Transactional
public class ScheduleDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	ArrayList<ServerBean> serverList = new ArrayList<ServerBean>();
	
	public ArrayList<ServerBean> getServerList(String[] servers){
		session = sessionFactory.getCurrentSession();
		Criteria cs = session.createCriteria(ServerBean.class);
		cs.add(Restrictions.in("name", servers));
		cs.addOrder(Order.asc("category"));
		cs.addOrder(Order.asc("environment"));
		cs.addOrder(Order.asc("name"));
		try {
			serverList = (ArrayList<ServerBean>) cs.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	System.out.println(serverList.size()+"size in dao");
		return serverList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
