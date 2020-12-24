package com.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtility {
	
	
	private  static SessionFactory sf;
	
	
	/// create the connection (session) to the DB 
	static {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		
		
	}
	
	// gets the session
	public static Session getSession() {
		Session session = sf.openSession();
		
		return session;
	}
	
	

}
