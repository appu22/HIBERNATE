package com.xworkz.instagram.service;

import com.xworkz.instagram.dao.InstagramDAO;
import com.xworkz.instagram.dao.InstagramDAOImple;
import com.xworkz.instagram.dto.InstagramDTO;

public class InstagramServiceImple implements InstagramService {

	InstagramDAO dao = new InstagramDAOImple();

	public void validataInstagram(InstagramDTO instagramDTO) {

		boolean flag = true;
		if (instagramDTO.getNoOfUsers() == 0 || instagramDTO.getNoOfUsers() < 500000) {
			System.out.println("Invalid no of users ");
			flag = false;
		}
		if (instagramDTO.getName() == null || instagramDTO.getName().length() < 4) {
			System.out.println("Invalid name ");
			flag = false;
		}
		if (instagramDTO.getType() == null) {
			System.out.println("Invalid Type ");
			flag = false;
		}
		if (instagramDTO.getVersion() == null || instagramDTO.getVersion().length() < 1) {
			System.out.println("Invalid Type ");
			flag = false;
		}
		if (instagramDTO.getNetworth() == 0 || instagramDTO.getNetworth() < 10000) {
			System.out.println("Invalid getNetworth ");
			flag = false;
		}
		if (flag) {
			dao.save(instagramDTO);
		}

	}

	public void validataFetchInstagramData() {
		System.out.println("validate Fetch Instagram Data ");
		dao.getInstagram();
	}

}
