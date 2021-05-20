package com.xworkz.app.DTO;

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

@Setter
@Getter
@Entity
@Table(name = "pizza_table")
public class PizzaDTO implements java.io.Serializable{
	
	@Column(name = "PIZZA_ID")
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public PizzaDTO(@NonNull String name, @NonNull double price, @NonNull String location, @NonNull boolean isAvailable,
			@NonNull String type) {
		super();
		this.name = name;
		this.price = price;
		this.location = location;
		this.isAvailable = isAvailable;
		this.type = type;
	}
	
}
