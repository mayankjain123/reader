package model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDB;

public class Order implements Serializable{

	private String date;
	private User user;
	private List orderItems;
	private Double salesTaxRate;
	private Double totalCost;
	private boolean paid;
	private Double subtotal;
	
	public Order(){
		this.orderItems = new ArrayList();
		addOrderItems();
	}
	
	private List addOrderItems(){
				
		ProductDB p = new ProductDB();
		OrderItem i1 = new OrderItem();
		i1.setProduct(p.getProducts().get("A_1"));
		this.orderItems.add(i1);
		OrderItem i2 = new OrderItem();
		i2.setProduct(p.getProducts().get("A_3"));
		this.orderItems.add(i2);
		OrderItem i3 = new OrderItem();
		i3.setProduct(p.getProducts().get("F_3"));
		this.orderItems.add(i3);
		return orderItems;
				
	}
	
	public List getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List orderItems) {
		this.orderItems = orderItems;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getSalesTaxRate() {
		return salesTaxRate;
	}
	public void setSalesTaxRate(Double salesTaxRate) {
		this.salesTaxRate = salesTaxRate;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
}

