package com.xworkz.mobile.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="mobile_table")
@NamedQuery(name="readAllRecords",query="from MobileEntity")
@NamedQuery(name="findMobilePriceByBrand",query="select mobile.price from MobileEntity as mobile where mobile.brand =:Brand")
@NamedQuery(name="findMaxPrice",query="select max(price) from MobileEntity")
@NamedQuery(name="findMinPrice",query="select min(price) from MobileEntity")
@NamedQuery(name="findTotalPrice",query="select sum(price) from MobileEntity")
@NamedQuery(name="updatePriceByColor",query="update MobileEntity as mobile set mobile.price=:Price where mobile.color=:Color")
@NamedQuery(name="deleteRowById",query="delete from MobileEntity mobile where mobile.id=:Id")
public class MobileEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="m_id")
	private int id;
	@Column(name="m_price")
	private double price;
	@Column(name="m_color")
	private String color;
	@Column(name="m_isAndroid")
	private boolean isAndroid;
	@Column(name="m_brand")
    private String brand;

	public MobileEntity() {
		
	}
	public MobileEntity(double price, String color, boolean isAndroid, String brand) {
		super();
		this.price = price;
		this.color = color;
		this.isAndroid = isAndroid;
		this.brand = brand;
	}
@Override
	public String toString() {
		return "MobileEntity [id=" + id + ", price=" + price + ", color=" + color + ", isAndroid=" + isAndroid
				+ ", brand=" + brand + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAndroid ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MobileEntity other = (MobileEntity) obj;
		if (isAndroid != other.isAndroid)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isAndroid() {
		return isAndroid;
	}
	public void setAndroid(boolean isAndroid) {
		this.isAndroid = isAndroid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	}
