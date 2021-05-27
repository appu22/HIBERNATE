package com.xworkz.headphones.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			session.beginTransaction();
			session.persist(factory);// persist --return type void , within boundry Trasaction ,used insert
			//session.save(dto);// save--serilizable, inside outside transaction ,used to insert,JPA
			session.getTransaction().commit();
		} catch (Exception e) {

		}

	}

	@Override
	public void fetchHeadphoneData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHeadphoneData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHeadphoneData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fetchAllHeadphoneRecords() {
		// TODO Auto-generated method stub

	}

}
