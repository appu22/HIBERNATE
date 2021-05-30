package com.xworkz.headphones.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "headphone_table") // table //entity name
//named query 
@NamedQueries({ @NamedQuery(name = "fetchAllHeadphoneRecords", query = "from HeadPhoneDTO"),
		@NamedQuery(name = "fecthHeaphoneDeatilsByName", query = "select head.headPhone_Type from HeadPhoneDTO AS head WHERE head.headPhone_Name=:name"),
		@NamedQuery(name = "fecthHeadPhonePriceByName", query = "select headPhone_Price from HeadPhoneDTO  where headPhone_Name=:hpname "),
		@NamedQuery(name = "fecthHeadPhoneColorAndNameById ", query = "select headPhone_Color from HeadPhoneDTO where headPhone_Id=:headid") })
public class HeadPhoneDTO implements java.io.Serializable {// clss name //object name

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	@Column(name = "HEADPHONE_ID") // database name
	private int headPhone_Id;

	@NonNull
	@Column(name = "HEADPHONE_NAME")
	private String headPhone_Name;

	@NonNull
	@Column(name = "HEADPHONE_PRICE")
	private double headPhone_Price;

	@NonNull
	@Column(name = "HEADPHONE_TYPE")
	private String headPhone_Type;

	@NonNull
	@Column(name = "HEADPHONE_COLOR")
	private String headPhone_Color;

	@NonNull
	@Column(name = "HEADPHONE_IS_WARRANTY")
	private boolean headPhone_isWarranty;

	public HeadPhoneDTO() {

		System.out.println("Headphone Object is created..............");
	}

	@Override
	public String toString() {
		return "HeadPhoneDTO [headPhone_Id=" + headPhone_Id + ", headPhone_Name=" + headPhone_Name
				+ ", headPhone_Price=" + headPhone_Price + ", headPhone_Type=" + headPhone_Type + ", headPhone_Color="
				+ headPhone_Color + ", headPhone_isWarranty=" + headPhone_isWarranty + "]";
	}

}
