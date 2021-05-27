package com.xworkz.headphones.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "headphone_table")
public class HeadPhoneDTO implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HEADPHONE_ID")
	private int headPhone_Id;

	@NonNull
	@Column(name = "HEADPHONE_NAME")
	private String headPhone_Name;

	@Column(name = "HEADPHONE_PRICE")
	@NonNull
	private double headPhone_Price;

	@Column(name = "HEADPHONE_TYPE")
	@NonNull
	private String headPhone_Type;

	@Column(name = "HEADPHONE_COLOR")
	@NonNull
	private String headPhone_Color;

	@Column(name = "HEADPHONE_IS_WARRANTY")
	@NonNull
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
