package com.xworkz.sewing.dto;

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
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sewing_table")
public class SewingDTO implements java.io.Serializable{
	@Column(name = "SEWING_ID")
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "SEWING_NAME")
	@NonNull
	private String name;
	
	@Column(name = "SEWING_COLOR")
	@NonNull
	private String color;
	
	@Column(name = "SEWING_MODEL")
	@NonNull
	private String model;
	
	
	@Column(name = "SEWING_PRICE")
	@NonNull
	private double price;
	
	
	@Column(name = "SEWING_IS_WORKING")
	@NonNull
	private boolean isWorking;
	
	public SewingDTO() {
		System.out.println("object created Sewing() DtO ");
	}

}
