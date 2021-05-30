package com.xworkz.singleton;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFact {

	private static SessionFactory factory = null;

	static {
		factory = new Configuration().configure().buildSessionFactory();
		System.out.println("Hibernate started..........");
	}

	public static SessionFactory getFactory() {
		if (Objects.nonNull(factory)) {
			System.out.println("SessionFactory Genrated...");
			return factory;
		} else {
			System.out.println("SessionFactory Not Genrated....");
		}
		return factory;
	}

	public static void closeFactory() {
		if (Objects.nonNull(factory)) {
			System.out.println("Session Factory Closed....");
			factory.close();
		} else {
			System.out.println("Session Factory not closed...");
		}
	}
}
