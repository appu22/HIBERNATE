package com.xworkz.headphones.dao;

import com.xworkz.headphones.dto.HeadPhoneDTO;

public interface HeadPhonesDAO {

	public void saveHeadphoneData(HeadPhoneDTO dto);

	void fetchHeadphoneData();

	void deleteHeadphoneData();

	void updateHeadphoneData();

	void fetchAllHeadphoneRecords();

	void fecthHeaphoneDeatilsByName(String name);

	void fecthHeadPhonePriceByName(String name);

	void fecthHeadPhoneColorAndNameById(int id);

}
