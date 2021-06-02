package com.xworkz.test;

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
@RequiredArgsConstructor
@ToString
@Entity
@Table(name="test_table")
public class TestDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEST_ID")
	private int id;
	
	
	@NonNull
	@Column(name = "TEST_NAME")
	private String testName;
	
	@NonNull
	@Column(name="TEST_SUBJECT_NAME")
	private String subjectName;
	
	
	public TestDTO() {
		
		System.out.println("Object created TestDTO");
	}

}
