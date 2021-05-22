package com.xworkz.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.app.DTO.PizzaDTO;

public class PizzaDAOImple implements PizzaDAO {

	@Override
	public void save(PizzaDTO pizzadto) {
		System.out.println("inside save method");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trasaction = null;
		try {
			Configuration configuration = new Configuration();// creating object
			configuration.configure("hibernate.cfg.xml");// optional
			// hibernate framework will started
			sessionFactory = configuration.buildSessionFactory();// creation session factory
			session = sessionFactory.openSession();// perform crud operation
			trasaction = session.beginTransaction();
//			session.save(pizzadto);
			session.persist(pizzadto);
			trasaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trasaction.rollback();

		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session Closed.......!");
			} else {
				System.out.println("Seesion connection failed....!");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("Session Factory closed......");
			} else {
				System.out.println("Session Factory Connection failed...");
			}
		}
	}

	@Override
	public void getPizza() {
		System.out.println("inside getpizza method....");
		SessionFactory sessionFactory = null;
		Session openSession = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			openSession = sessionFactory.openSession();
			PizzaDTO pizzadto = openSession.get(PizzaDTO.class, 9);
			System.out.println(pizzadto.toString());

		} catch (Exception exception) {
			exception.printStackTrace();

		} finally {
			if (openSession != null) {
				openSession.close();
				System.out.println("Session connection closed.........");
			} else {
				System.out.println("Session connectio Failed..........");
			}

			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("Session Factory connection closed......!");
			} else {
				System.out.println("Session connection failed");
			}
		}
	}
}
