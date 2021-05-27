package com.xworkz.instagram.dao;

import com.xworkz.instagram.dto.InstagramDTO;

public interface InstagramDAO {
	
	
	public void save(InstagramDTO instagramDTO);
	
	public void getInstagram();
	
	void getAllRecord();

}
