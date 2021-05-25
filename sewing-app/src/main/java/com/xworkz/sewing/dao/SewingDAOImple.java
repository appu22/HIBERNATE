package com.xworkz.sewing.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.sewing.dto.SewingDTO;

public class SewingDAOImple implements SewingDAO {

	public void save(SewingDTO dto) {
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
//			session.save(dto);
			session.persist(dto);
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

	public void getSewingData() {
		System.out.println("inside sewing method....");
		SessionFactory sessionFactory = null;
		Session openSession = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			openSession = sessionFactory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 1);
			System.out.println(sewingDTO);

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

	public void updatSewing() {
		System.out.println("inside sewing update  method....");
		SessionFactory sessionFactory = null;
		Session openSession = null;
		Transaction transaction = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			openSession = sessionFactory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 1);
			double price = sewingDTO.getPrice();
			System.out.println("price " + price);
			System.out.println("before updating..........");

			sewingDTO.setName(sewingDTO.getName());
			sewingDTO.setColor(sewingDTO.getColor());
			sewingDTO.setPrice(2500);
			sewingDTO.setModel(sewingDTO.getModel());
			sewingDTO.isWorking();
			transaction = openSession.beginTransaction();
			openSession.update(sewingDTO);
			transaction.commit();
			System.out.println("price updated");

		} catch (Exception exception) {
			exception.printStackTrace();
			transaction.rollback();

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

	public void deleteSewingData() {
		System.out.println("inside sewingdao imple delete method....");
		SessionFactory sessionFactory = null;
		Session openSession = null;
		Transaction beginTransaction = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			openSession = sessionFactory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 1);
			beginTransaction = openSession.beginTransaction();
			openSession.delete(sewingDTO);
			beginTransaction.commit();
			System.out.println("Record deleted successfull.....");

		} catch (Exception exception) {
			exception.printStackTrace();
			beginTransaction.rollback();

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
