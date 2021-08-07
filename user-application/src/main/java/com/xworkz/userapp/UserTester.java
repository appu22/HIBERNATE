package com.xworkz.userapp;

import java.util.List;

import com.xworkz.userapp.dao.UserDAOImple;
import com.xworkz.userapp.dao.UsrerDAO;
import com.xworkz.userapp.dto.UserDTO;

public class UserTester {

	public static void main(String[] args) {
		
		System.out.println("***************Program Start*******");

//		UserDTO dto = new UserDTO("APPU",821245454,"AT POST BELAGAVI");

		UserDTO dto = new UserDTO("Geeta",78945612,"AT POST BELAGAVI");
		
		
		UsrerDAO daoimple = new UserDAOImple();

		daoimple.saveUserData(dto);
		//daoimple.fetchAllData();

//		System.out.println(fetchAllData);

		System.out.println("***************Program End*******");
	}

}
