package com.HQLExample;

import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLExample {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Student5 s1 = new Student5();
		s1.setId(3);
		s1.setName("Advil");
		s1.setCity("pune");
		
		Certificate5 c1 = new Certificate5();
		c1.setCourse("Medical");
		c1.setDuration("4 years");
		
		s1.setCerti(c1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		//s.save(s1);
		
		//HQL 
		//Syntax:
		
		// select Query
		//String query = "from Student5";        //[1]
		//String query = "from Student5 where city='Akole'";  //[2]
		//String query = "from Student5 where city=:x";   //[3]
		String query = "from Student5 as s where s.city=:x and s.name=:n";
		
		Query q = s.createQuery(query);  // it will return Query object // for HQL we use createQuery()
		//q.setParameter("x","Akole");       //[3]
		q.setParameter("x", "Akole");    //[4]
		q.setParameter("n", "saurabh");  //[4]
		
		// Query-single result-(Unique)
		//q.uniqueResult();
		
		// Query-Multiple result-list
		List<Student5> list = q.list();
		
		for (Student5 stu : list) {
			System.out.println(stu.getName()+" : "+stu.getCerti().getCourse());
		}
		
		System.out.println("__________________________________________");
		
		// delete Query
		Query q2 = s.createQuery("delete from Student5 s where s.city=:c");
		q2.setParameter("c", "pune");
		int r = q2.executeUpdate();
		System.out.println("deleted:");
		System.out.println(r);
		
		// update Query
		Query q3 = s.createQuery("update Student5 set city='pune' where name='saurabh'");
		int i = q3.executeUpdate();
		System.out.println(i+" "+"Object updated");
		
		// how to execute join query
		// to execute join query we need OneToMany relationship
		// this query is executed in OneToMany example
		
		
		tx.commit();
		s.close();
		factory.close();
		
	}
	

}
