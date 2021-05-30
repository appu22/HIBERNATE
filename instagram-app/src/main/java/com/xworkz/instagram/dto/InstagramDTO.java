package com.xworkz.instagram.dto;

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
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
//@ToString
@Entity
@Table(name = "instagram_app")
@NamedQueries({
	@NamedQuery(name="getAllRecord",query="from InstagramDTO"),
	@NamedQuery(name="getOneRowDataOfInstagram",query="from InstagramDTO where name='instagram lite'"),
	
	@NamedQuery(name="getMaximumNofUsersOfInstagram",query="select max(noOfUsers) from InstagramDTO "),
	@NamedQuery(name="getMinimumNumberOfUsersInsta",query="select min(noOfUsers) from InstagramDTO"),
	@NamedQuery(name="getCeoNamesByInstaName",query="select ceo from InstagramDTO where name='instagram'"),
	@NamedQuery(name="getCountOfAllInstagramRecords",query="select count(names) from InstagramDTO"),
	@NamedQuery(name="getSumOfAllInstagramUsers",query="select sum(noOfUsers) from InstagramDTO")
})
public class InstagramDTO implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INSTA_ID")
	private int id;

	@Column(name = "INSTA_NAME")
	@NonNull
	private String name;

	@Column(name = "INSTA_CEO")
	@NonNull
	private String ceo;

	@Column(name = "INSTA_NO_OF_USERS")
	@NonNull
	private int noOfUsers;

	@Column(name = "INSTA_NET_WORTH")
	@NonNull
	private double networth;

	@Column(name = "INSTA_TYPE")
	@NonNull
	private String type;

	@Column(name = "VERSION")
	@NonNull
	private String version;

	public InstagramDTO() {
		System.out.println("object created.............");
	}

	@Override
	public String toString() {
		return "InstagramDTO [ID = " + id + ", Name : = " + name + ", CEO : = " + ceo + ", No Of Users : = " + noOfUsers
				+ ", NetWorth = " + networth + ", Type : = " + type + ", Version : = " + version + "]";
	}

}
