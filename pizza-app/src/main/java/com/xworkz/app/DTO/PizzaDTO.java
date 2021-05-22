package com.xworkz.app.DTO;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@ToString
@Table(name = "pizza_table")
public class PizzaDTO implements java.io.Serializable {

	@Column(name = "PIZZA_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pizzaID;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "IS_AVAILABLE")
	private boolean isAvailable;

	@Column(name = "TYPE")
	private String type;

	public PizzaDTO() {
		System.out.println(getClass().getSimpleName() + " : Object created ");
	}

	public PizzaDTO(String name, double price, String location, boolean isAvailable, String type) {
		super();
		this.name = name;
		this.price = price;
		this.location = location;
		this.isAvailable = isAvailable;
		this.type = type;
	}

}
