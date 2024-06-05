package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.HQLExample.Student5;

public class CriteriaExample {
	
	public static void main(String[] args) {
		
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria c = s.createCriteria(Student5.class);
		
		// Restrictions , filter
		//c.add(Restrictions.eq("certi.course", "Bank"));
		//c.add(Restrictions.gt("id", 5));
		//c.add(Restrictions.lt("id", 5));
		c.add(Restrictions.like("certi.course", "java%"));
		
		List<Student5> list = c.list();
		
		for (Student5 st : list) {
			System.out.println(st);
		}
		
		
		
		
		
		
		s.close();
		
		
	}

}
