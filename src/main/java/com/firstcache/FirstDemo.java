package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HQLExample.Student5;

public class FirstDemo {
	
	public static void main(String[] args) {
		    
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		// First Level Cache - Bydefault Enable
		
		Student5 stu = s.get(Student5.class, 1);
		System.out.println(stu);
		
		System.out.println("Working Something....");
		
		Student5 stu2 = s.get(Student5.class, 1);
		System.out.println(stu2);
		
		System.out.println(s.contains(stu2));
		// it will check whether stu2 is present in cache memory or not.
		// it will give result in true or false.
		
		s.close();
		
		
	}

}
