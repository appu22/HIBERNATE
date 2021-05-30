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
			Query query = session.createNamedQuery("getAllRecord");
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

	public void getOneRowDataOfInstagram() {
		System.out.println("getOneRowDataOfInstagram");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
//			String hql = "select i.name from InstagramDTO as i where id=1";
//			String hql = "select id from InstagramDTO where name='instagram lite'";
			Query query = session.createNamedQuery("getOneRowDataOfInstagram");
//			System.out.println(query.hashCode());
//			String string = query.toString();
			List list = query.list();
			System.out.println("query : " + list);
			
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

	public void getMaximumNofUsersOfInstagram() {
		System.out.println("select max(noOfUsers) from InstagramDTO ");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
//			String getMax = "select max(noOfUsers) from InstagramDTO ";
			Query query = session.createNamedQuery("getMaximumNofUsersOfInstagram");
			List list = query.list();
			System.out.println("Max number of Users : " + list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			} else {
				System.out.println("Session closed.........");
			}
			if (factory != null) {
				System.out.println("SessoioFactory closed...............");
			}

		}
	}

	public void getMinimumNumberOfUsersInsta() {
		System.out.println("getMinimumNumberOfUsersInsta");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();

			session = factory.openSession();
//			String getMin = "select min(noOfUsers) from InstagramDTO";
			Query query = session.createNamedQuery("getMinimumNumberOfUsersInsta");
			List list = query.list();
			System.out.println("Min No of users : " + list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				System.out.println("Session colsed....");
				session.close();
			} else {
				System.out.println("Session not Closed......");
			}
			if (factory != null) {
				System.out.println("SessionFactory  Closed........!");
				factory.close();
			} else {
				System.out.println("Session Factory not closed........");
			}

		}

	}

	public void getCeoNamesByInstaName() {
		System.out.println("getCeoNamesByInstaName");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();

			session = factory.openSession();
			String ceoName = "select ceo from InstagramDTO where name='instagram'";
			Query query = session.createNamedQuery("getCeoNamesByInstaName");
			List list = query.list();
			System.out.println("Ceo name  : " + list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				System.out.println("Session colsed....");
				session.close();
			} else {
				System.out.println("Session not Closed......");
			}
			if (factory != null) {
				System.out.println("SessionFactory  Closed........!");
				factory.close();
			} else {
				System.out.println("Session Factory not closed........");
			}

		}
	}

	public void getCountOfAllInstagramRecords() {
		System.out.println("getCountOfAllInstagramRecords");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();

			session = factory.openSession();
//			String countRow = "select count(names) from InstagramDTO";
			Query query = session.createNamedQuery("getCountOfAllInstagramRecords");
			List list = query.list();
			System.out.println("Count Of rows  : " + list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				System.out.println("Session colsed....");
				session.close();
			} else {
				System.out.println("Session not Closed......");
			}
			if (factory != null) {
				System.out.println("SessionFactory  Closed........!");
				factory.close();
			} else {
				System.out.println("Session Factory not closed........");
			}

		}
	}

	public void getSumOfAllInstagramUsers() {
		System.out.println("getSumOfAllInstagramUsers");
		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure().buildSessionFactory();

			session = factory.openSession();
//			String sumOfUsers = "select sum(noOfUsers) from InstagramDTO";
			Query query = session.createNamedQuery("getSumOfAllInstagramUsers");
			List list = query.list();
			System.out.println("Sum Of Users  : " + list.toString());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				System.out.println("Session colsed....");
				session.close();
			} else {
				System.out.println("Session not Closed......");
			}
			if (factory != null) {
				System.out.println("SessionFactory  Closed........!");
				factory.close();
			} else {
				System.out.println("Session Factory not closed........");
			}

		}
	}
}
