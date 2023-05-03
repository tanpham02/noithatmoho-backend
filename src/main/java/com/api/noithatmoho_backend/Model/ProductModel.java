package com.api.noithatmoho_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "products")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String discount;
	private float prices;
	private int quantity_sold;
	private int quantity_stock;
	private String image_url;
	private String size;
	private int type_id;
	private String created_at;
	private String created_by;

	public ProductModel() {

	}

	public ProductModel(String name, String discount, float prices, int quantity_sold, int quantity_stock,
			String image_url, String size, int type_id, String created_at, String created_by) {
		super();
		this.name = name;
		this.discount = discount;
		this.prices = prices;
		this.quantity_sold = quantity_sold;
		this.quantity_stock = quantity_stock;
		this.image_url = image_url;
		this.size = size;
		this.type_id = type_id;
		this.created_at = created_at;
		this.created_by = created_by;
	}

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

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public float getPrices() {
		return prices;
	}

	public void setPrices(float prices) {
		this.prices = prices;
	}

	public int getQuantity_sold() {
		return quantity_sold;
	}

	public void setQuantity_sold(int quantity_sold) {
		this.quantity_sold = quantity_sold;
	}

	public int getQuantity_stock() {
		return quantity_stock;
	}

	public void setQuantity_stock(int quantity_stock) {
		this.quantity_stock = quantity_stock;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	

	
}
