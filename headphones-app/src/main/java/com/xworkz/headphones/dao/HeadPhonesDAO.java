package com.xworkz.headphones.dao;

import com.xworkz.headphones.dto.HeadPhoneDTO;

public interface HeadPhonesDAO {

	void saveHeadphoneData(HeadPhoneDTO dto);

	void fetchHeadphoneData();

	void deleteHeadphoneData();

	void updateHeadphoneData();

	void fetchAllHeadphoneRecords();

}
