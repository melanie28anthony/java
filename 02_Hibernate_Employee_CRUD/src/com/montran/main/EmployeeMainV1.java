package com.montran.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.montran.pojo.Employee;

public class EmployeeMainV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee= new Employee(104,"mela",2000);
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// step 4 :: create new transaction using session object
		Transaction transaction = session.beginTransaction();

		// step 5 :: save object in session
		session.save(employee);
		transaction.commit();
	}

}
