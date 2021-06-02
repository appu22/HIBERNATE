package com.xworkz.headphones.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.xworkz.headphones.dto.HeadPhoneDTO;
import com.xworkz.singleton.SessionFact;

public class HeadPhonesDAOImple implements HeadPhonesDAO {

	@Override
	public void saveHeadphoneData(HeadPhoneDTO dto) {
		System.out.println("invoke  save Headphone Data()  ");
		Session session = null;

		try {
//			Configuration configuration = new Configuration();
//			configuration.configure();
//			SessionFactory buildSessionFactory = configuration.buildSessionFactory();
//			Session openSession = buildSessionFactory.openSession();
//			openSession.beginTransaction();
//			openSession.save(dto);
//			openSession.getTransaction().commit();

			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
			System.out.println("After session open ");
			session.beginTransaction();
			session.save(dto);// persist --return type void , within boundry Trasaction ,used insert
								// session.save(dto);// save--serilizable, inside outside transaction ,used to
								// insert,JPA
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				System.out.println("Session connection closed..........");
				session.close();
			} else {
				System.out.println("Session Not Connection.............! ");
			}
		}

	}

	@Override
	public void fetchHeadphoneData() {
		Session session = null;

		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
			HeadPhoneDTO headhone = session.get(HeadPhoneDTO.class, 1);
			System.out.println("get row details :  " + headhone);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				System.out.println("Session closed.....");
				session.close();
			} else {
				System.out.println("Session not closed............");
			}
		}

	}

	@Override
	public void deleteHeadphoneData() {
		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
			HeadPhoneDTO phoneDTO = session.get(HeadPhoneDTO.class, 3);
			System.out.println("deleted successfull...." + phoneDTO);
			session.beginTransaction();
			session.delete(phoneDTO);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				System.out.println("Session Closed.......");
				session.close();
			} else {
				System.out.println("session Not closed.......");
			}

		}
	}

	@Override
	public void updateHeadphoneData() {

		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
			HeadPhoneDTO phonedto = session.get(HeadPhoneDTO.class, 1);
//			System.out.println("before : "+phonedto);
			phonedto.setHeadPhone_Price(600);
			phonedto.setHeadPhone_Color("green");
			System.out.println("Updated Succssfull..." + phonedto);
			session.beginTransaction();
			session.merge(phonedto);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				System.out.println("Session Closed......");
				session.close();
			} else {
				System.out.println("session not closed............");
			}

		}
	}

	@Override
	public void fetchAllHeadphoneRecords() {
		System.out.println("fetch All Headphone Records");
		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
//			String hql = "from HeadPhoneDTO";
			Query query = session.createNamedQuery("fetchAllHeadphoneRecords");
			List<HeadPhoneDTO> list = query.list();
			for (HeadPhoneDTO headPhoneDTO : list) {
				System.out.println(headPhoneDTO);
			}
//			Iterator<HeadPhoneDTO> iterator = list.iterator();
//			while (iterator.hasNext()) {
//				HeadPhoneDTO next = iterator.next();
//				System.out.println(next);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				System.out.println("Session closed.........");
				session.close();
			} else {
				System.out.println("Session not Closed.......");
			}
		}

//		
	}

	@Override
	public void fecthHeaphoneDeatilsByName(String name) {
		System.out.println("fecth Heaphone Deatils By Name");
		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
//			String fecthName = "select headPhone_Type from HeadPhoneDTO WHERE headPhone_Name='" + name + "'";
//			String fecthName = "select head.headPhone_Type from HeadPhoneDTO AS head WHERE head.headPhone_Name=:name";
//			select HEADPHONE_NAME from hibernate.headphone_table where HEADPHONE_ID=1;
			Query query = session.createNamedQuery("fecthHeaphoneDeatilsByName");
			query.setParameter("name", name);
			List list = query.list();
			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				System.out.println("Session Cloesd........");
				session.close();
			} else {
				System.out.println("Session not Closed.....");
			}

		}

	}

	@Override
	public void fecthHeadPhonePriceByName(String name) {
		System.out.println("fecth HeadPhone Price By Name And Id");
		Session session = null;
		try {

			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
//			String hql = "select headPhone_Price from HeadPhoneDTO  where headPhone_Name=:hpname ";
//			select HEADPHONE_PRICE FROM hibernate.headphone_table where HEADPHONE_ID=1 and HEADPHONE_NAME='One+' ;
			Query query = session.createNamedQuery("fecthHeadPhonePriceByName");
			query.setParameter("hpname", name);
			List<HeadPhoneDTO> list = query.list();
			for (HeadPhoneDTO headphone : list) {
				System.out.println(headphone);
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				System.out.println("Session Closed......");
				session.close();
			} else {
				System.out.println("Session not Closed.............");
			}

		}
	}

	@Override
	public void fecthHeadPhoneColorAndNameById(int id) {
		System.out.println("fecth HeadPhone Color And Name By Id using named query ");
		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			session = factory.openSession();
//			String hql = "select headPhone_Color from HeadPhoneDTO where headPhone_Id=:headid ";
			Query query = session.createNamedQuery("fecthHeadPhoneColorAndNameById");
			query.setParameter("headid", id);
			List list = query.list();
			String string = list.toString();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				System.out.println("Session closed....");
				session.close();
			} else {
				System.out.println("Session Not closed.........");
			}
			SessionFact.closeFactory();
		}

	}

}
