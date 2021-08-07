package com.xworkz.userapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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

@NamedQuery(name = "fecthAll", query = "from UserDTO")

@Table(name = "user_table")

public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "U_ID")
//	@NonNull
	private int id;

	@Column(name = "U_NAME")
	@NonNull
	private String UserName;

	@Column(name = "U_PHONE_NO")
	@NonNull
	private long phoneNo;

	@Column(name = "U_ADDRESS_DETAILS")
	@NonNull
	private String address;

	public UserDTO() {

		System.out.println(getClass().getSimpleName() + " Object created....");
	}

}
