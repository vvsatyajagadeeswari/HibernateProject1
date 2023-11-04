package com.anudipfound.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int id;
	
	@Column(name="cart_price")
	private int price;
	
	@ManyToMany
	@JoinTable(name="cart_product",joinColumns=@JoinColumn(name="cart_id"),
	inverseJoinColumns=@JoinColumn(name="pro_id"))
	private Set<Product> product=new HashSet<Product>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Cart(int id, int price, Set<Product> product) {
		super();
		this.id = id;
		this.price = price;
		this.product = product;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}	
