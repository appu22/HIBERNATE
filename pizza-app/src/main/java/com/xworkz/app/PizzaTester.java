package com.xworkz.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.app.DTO.PizzaDTO;

public class PizzaTester {

	public static void main(String[] args) {
			Configuration configuration = new Configuration();//creating object
			configuration.configure("hibernate.cfg.xml");//optional  
			//hibernate framework will started
			SessionFactory sessionFactory = configuration.buildSessionFactory();//creation session factory
			Session session =sessionFactory.openSession();//perform crud operation
			
		PizzaDTO pizzadto = new PizzaDTO("corn", 150, "Belagavi", false, "veg");
		Transaction trasaction = session.beginTransaction();
		session.save(pizzadto);
		trasaction.commit();
		

	}

}
