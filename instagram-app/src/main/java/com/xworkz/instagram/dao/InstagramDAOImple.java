package com.xworkz.instagram.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.instagram.dto.InstagramDTO;

public class InstagramDAOImple implements InstagramDAO {

	public void save(InstagramDTO instagramDTO) {

		System.out.println("inside save method");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction trasaction = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			trasaction = session.beginTransaction();
//			session.save(instagramDTO);
			session.persist(instagramDTO);
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

	public void getInstagram() {
		System.out.println("inside insta get method....");
		SessionFactory sessionFactory = null;
		Session openSession = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			openSession = sessionFactory.openSession();
			InstagramDTO InstagramDTO = openSession.get(InstagramDTO.class, 1);
			System.out.println(InstagramDTO);

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
