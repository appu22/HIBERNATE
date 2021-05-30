package com.xworkz.instagram.dao;

import com.xworkz.instagram.dto.InstagramDTO;

public interface InstagramDAO {

	public void save(InstagramDTO instagramDTO);

	public void getInstagram();

	void getAllRecord();

	void getOneRowDataOfInstagram();

	void getMaximumNofUsersOfInstagram();

	void getMinimumNumberOfUsersInsta();

	void getCeoNamesByInstaName();
	
	void getCountOfAllInstagramRecords();
	
	
	void getSumOfAllInstagramUsers();
}
