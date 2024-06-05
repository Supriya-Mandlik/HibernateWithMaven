package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HQLExample.Student5;

public class SecondCacheDemo {
	
	public static void main(String[] args) {
		
	SessionFactory factory =new Configuration().configure().buildSessionFactory();
	
	Session session1 = factory.openSession();
	// first
	
	Student5 st1 = session1.get(Student5.class, 1);
	System.out.println(st1);
	
	session1.close();
	
	Session session2 = factory.openSession();
	//second
	
	Student5 st2 = session2.get(Student5.class, 1);
	System.out.println(st2);
	
	session2.close();
	
	
		
		
	}

}
