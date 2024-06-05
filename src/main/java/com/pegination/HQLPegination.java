package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.HQLExample.Student5;

public class HQLPegination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		
		Query q = s.createQuery("from Student5");
		
		// implementing pegination using hibernate
		
		q.setFirstResult(0);
		
		q.setMaxResults(5);
		
		List<Student5> list = q.list();
		
		for (Student5 stu : list) {
			System.out.println(stu.getId()+" : "+stu.getName()+" : "+stu.getCity());
		}
		
		
		s.close();
		factory.close();
		
	}

}
