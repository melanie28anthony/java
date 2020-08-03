package com.montran.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	
	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			if (factory != null) {
				return factory;
			}
		} catch (Exception e) {
			System.out.println("Excpetion while creating session factory !!");
			e.printStackTrace();
		}
		return null;
	
	}
}
