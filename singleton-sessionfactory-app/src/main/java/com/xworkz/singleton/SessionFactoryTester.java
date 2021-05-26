package com.xworkz.singleton;

import org.hibernate.SessionFactory;

public class SessionFactoryTester {

	public static void main(String[] args) {

		System.out.println("Programs Start");
		SessionFactory factory = SessionFact.getFactory();
		System.out.println(factory.hashCode());
		SessionFactory factory2 = SessionFact.getFactory();
		System.out.println(factory2.hashCode());
		SessionFact.closeFactory();
		System.out.println("Program Ended...");
	}

}
