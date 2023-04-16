package com.api.noithatmoho_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")
public class UsersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String phone_number;
	private String full_name;
	private String password;
	private int is_admin;
	private String birthday;
	private String address;
	private String otp;
	private String vouchers;
	private String checkout;
	private String avatar;
	private String product_boughts;
	private String total_order;
	private String transactions;
	
	public UsersModel() {
		super();
	}

	public UsersModel(String email, String phone_number, String full_name, String password, int is_admin,
			String birthday, String address, String otp, String vouchers, String checkout, String avatar,
			String product_boughts, String total_order, String transactions) {
		super();
		this.email = email;
		this.phone_number = phone_number;
		this.full_name = full_name;
		this.password = password;
		this.is_admin = is_admin;
		this.birthday = birthday;
		this.address = address;
		this.otp = otp;
		this.vouchers = vouchers;
		this.checkout = checkout;
		this.avatar = avatar;
		this.product_boughts = product_boughts;
		this.total_order = total_order;
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getVouchers() {
		return vouchers;
	}

	public void setVouchers(String vouchers) {
		this.vouchers = vouchers;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getProduct_boughts() {
		return product_boughts;
	}

	public void setProduct_boughts(String product_boughts) {
		this.product_boughts = product_boughts;
	}

	public String getTotal_order() {
		return total_order;
	}

	public void setTotal_order(String total_order) {
		this.total_order = total_order;
	}

	public String getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}

	
	

	

}
