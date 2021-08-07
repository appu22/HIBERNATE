package com.xworkz.userapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.userapp.dto.UserDTO;

public class UserDAOImple implements UsrerDAO {

	public UserDAOImple() {
		System.out.println("USerDAOImple");
	}

	public void saveUserData(UserDTO dto) {
		System.out.println("SaveUSerDATA");
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction beginTransaction = null;
		try {
			Configuration configure = new Configuration();
			configure.configure("hibernate.cfg.xml");
			sessionFactory = configure.buildSessionFactory();
			session =sessionFactory.openSession();
			beginTransaction = session.beginTransaction();
			System.out.println(dto);
			session.save(dto); 
//			session.persist(dto);
			beginTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			beginTransaction.rollback();
		} finally {
			if (session != null) {
				System.out.println("Session Closed...");
				session.close();

			} else {
				System.out.println("Session not closed.....");
			}
			if (sessionFactory != null) {
				System.out.println("sessionFactory closed");
				sessionFactory.close();

			} else {
				System.out.println("SessionFactory not closed.....");
			}
		}

	}

	@SuppressWarnings("finally")
	public List<UserDTO> fetchAllData() {
		System.out.println("invoking fetchAllData method ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			SessionFactory buildSessionFactory = configuration.buildSessionFactory();
			Session openSession = buildSessionFactory.openSession();

			Query query = openSession.createNamedQuery("fecthAll");
			List<UserDTO> list = query.list();

			for (UserDTO userdto : list) {
				System.out.println(userdto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				System.out.println("Session Closed...");
				session.close();

			} else {
				System.out.println("Session not closed.....");

				if (sessionFactory != null) {
					System.out.println("sessionFactory closed");
					sessionFactory.close();

				} else {
					System.out.println("Session not closed.....");
				}
			}
			return null;
		}

	}
}
