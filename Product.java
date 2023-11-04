package com.anudipfound.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id")
	private int id;
	
	@Column(name="pro_name")
	private String name;
	
	@Column(name="pro_price")
	private int price;
	
	@ManyToMany(mappedBy="product")
	private Set<Cart> cart=new HashSet<Cart>();

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public Product(int id, String name, int price, Set<Cart> cart) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.cart = cart;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
