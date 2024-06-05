package com.SQLQueriesUsingHibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.HQLExample.Student5;

public class SQLExample {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session s = factory.openSession();
		
		// SQL Query
		String q = "select * from Student5";
		
		NativeQuery nq =s.createSQLQuery(q);  // it will return object of Native Query // For SQL we use createSQLQuery()
		// NativeQuery is an interface
		
		List<Object[]> list = nq.list();  // it will return data in object form
		
		for (Object[] st : list) {
			//System.out.println(Arrays.deepToString(st));
			System.out.println(st[4]+" : "+st[3]);
		}
		
		
		s.close();
		factory.close();
		
	}

}
