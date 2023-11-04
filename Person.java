package com.anudipfound.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Person_id")
	private int id;
	
	@Column(name="Person_name")
	private String name;
	
	@OneToOne(mappedBy="person",cascade=CascadeType.ALL)
	private Passport address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getAddress() {
		return address;
	}

	public void setAddress(Passport address) {
		this.address = address;
	}

	public Person(int id, String name, Passport address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

		
}
