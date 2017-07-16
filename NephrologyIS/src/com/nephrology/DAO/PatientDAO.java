package com.nephrology.DAO;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hibernate.utilities.HibernateUtilities;
import com.nephrology.bean.PatientBean;

public class PatientDAO {
	SessionFactory factory;
	Session session;
	Transaction tx = null;
	ArrayList<PatientBean> patientList ;	
	@SuppressWarnings("unchecked")
	public ArrayList<PatientBean> getPatients(PatientBean patientbean){
		
		 factory = HibernateUtilities.getSessionFactory();
		 session = factory.openSession();
		 try{
			 tx = session.beginTransaction();
			 System.out.println(patientbean.getDoc_id());
			 
			 Criteria cs = session.createCriteria(PatientBean.class);
			 cs.add(Restrictions.ilike("doc_id", patientbean.getDoc_id().trim()));
			 System.out.println(cs);
			 patientList = (ArrayList<PatientBean>)cs.list();
			// System.out.println(patientList.size());
			 tx.commit();
			 
		 }catch(HibernateException e){
			 if(tx != null){
				 tx.rollback();
				 System.out.println(e);
			 }
			 
		 }finally{
			 session.close();
			 
		 }
		return patientList;
	}

}
