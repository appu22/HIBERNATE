package com.xworkz.instagram;

import com.xworkz.instagram.dao.InstagramDAO;
import com.xworkz.instagram.dao.InstagramDAOImple;
import com.xworkz.instagram.dto.InstagramDTO;

public class InstagramTester {

	public static void main(String[] args) {
		
		InstagramDTO dto = new InstagramDTO("insta story save", "hebbuli", 7045400, 200000.0, "Not active", "insta 2");
		
		InstagramDAO instagramDAOImple = new InstagramDAOImple();
		
		instagramDAOImple.save(dto);
		instagramDAOImple.getInstagram();
		
	}

}
