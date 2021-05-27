package com.xworkz.instagram.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

	public void getAllRecord() {
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			String hql = "from InstagramDTO";
//			String hql = "select name from  com.xworkz.instagram.dto.InstagramDTO where id=2";
			Query query = session.createQuery(hql);
			List<InstagramDTO> list = query.list();
			for (InstagramDTO instagramDTO : list) {
				System.out.println(instagramDTO);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null && factory != null) {
				System.out.println("Session and Factory Closed.........");
				session.close();
				factory.close();

			} else {
				System.out.println("Session and Factory not connected");
			}
		}
	}

}
