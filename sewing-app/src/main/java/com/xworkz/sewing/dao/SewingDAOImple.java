package com.xworkz.sewing.dao;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import com.xworkz.sewing.dto.SewingDTO;
import com.xworkz.singleton.SessionFact;

public class SewingDAOImple implements SewingDAO {

	public void save(SewingDTO dto) {
		System.out.println("inside save method");
		Session session = null;
		try {
			SessionFactory factory = SessionFact.getFactory();// calling get method
			// created singlton class //only one object created
			session = factory.openSession();
			session.beginTransaction();
//			session.save(dto);
			session.persist(dto);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session Closed.......!");
			} else {
				System.out.println("Seesion connection failed....!");
			}
		}
	}

	public void getSewingData() {
		System.out.println("inside sewing method....");
		Session openSession = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			openSession = factory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 2);
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

		}
	}

	public void updatSewing() {
		System.out.println("inside sewing update  method....");
		Session openSession = null;
		try {
			SessionFactory factory = SessionFact.getFactory();
			openSession = factory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 2);
			double price = sewingDTO.getPrice();
			System.out.println("price " + price);
			System.out.println("before updating..........");

			sewingDTO.setName(sewingDTO.getName());
			sewingDTO.setColor(sewingDTO.getColor());
			sewingDTO.setPrice(2500);
			sewingDTO.setModel(sewingDTO.getModel());
			sewingDTO.isWorking();
			openSession.beginTransaction();
			openSession.update(sewingDTO);
			openSession.getTransaction().commit();
			System.out.println("price updated");

		} catch (Exception exception) {
			exception.printStackTrace();
			openSession.getTransaction().rollback();

		} finally {
			if (openSession != null) {
				openSession.close();
				System.out.println("Session connection closed.........");
			} else {
				System.out.println("Session connectio Failed..........");
			}

		}
	}

	public void deleteSewingData() {
		System.out.println("inside sewingdao imple delete method....");
		Session openSession = null;
		try {

			SessionFactory factory = SessionFact.getFactory();
			openSession = factory.openSession();
			SewingDTO sewingDTO = openSession.get(SewingDTO.class, 1);
			openSession.beginTransaction();
			openSession.delete(sewingDTO);
			openSession.getTransaction().commit();
			System.out.println("Record deleted successfull.....");

		} catch (Exception exception) {
			exception.printStackTrace();
			openSession.getTransaction().rollback();

		} finally {
			if (openSession != null) {
				openSession.close();
				System.out.println("Session connection closed.........");
			} else {
				System.out.println("Session connectio Failed..........");
			}
			System.out.println("SessionFactory.........Closed...");
			SessionFact.closeFactory();
			// calling closeFactory method using class name
			// its static method
			//

		}
	}
}
