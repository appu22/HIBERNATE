package com.xworkz.app.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "pizza_table")
public class PizzaDTO {
	@Column(name = "PIZZA_ID")
	@NonNull
	private int pizzaID;

	@Column(name = "NAME")
	@NonNull
	private String name;

	@Column(name = "PRICE")
	@NonNull
	private double price;

	@Column(name = "LOCATION")
	@NonNull
	private String location;

	@Column(name = "IS_AVAILABLE")
	@NonNull
	private boolean isAvailable;

	@Column(name = "TYPE")
	@NonNull
	private String type;

	public PizzaDTO() {
		System.out.println(getClass().getSimpleName() + " : Object created ");
	}
}
