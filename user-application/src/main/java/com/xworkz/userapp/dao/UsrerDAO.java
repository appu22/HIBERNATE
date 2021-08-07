package com.xworkz.userapp.dao;

import java.util.List;

import com.xworkz.userapp.dto.UserDTO;

public interface UsrerDAO {

	public void saveUserData(UserDTO dto);

	public List<UserDTO> fetchAllData();

}
