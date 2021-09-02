package com.xworkz.camera.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="camera_table")

public class CameraEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="c_id")
	private int id;
	@Column(name="c_name")
	private String name;
	@Column(name="c_brand")
	private String brand;
	@Column(name="c_model")
	private String model;
	@Column(name="c_megapixel")
	private double megapixel;
	@Column(name="c_connectivity")
	private boolean connectivity;
	@Column(name="c_displaysize")
	private double displaysize;
	@Column(name="c_framesPerSecond")
	private int framesPerSecond;
	@Column(name="c_lensType")
	private String lensType;
	@Column(name="c_madeBy")
	private String madeBy;

	public CameraEntity() {
	}

	public CameraEntity( String name, String brand, String model, double megapixel, boolean connectivity,
			double displaysize, int framesPerSecond, String lensType, String madeBy) {
		super();
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.megapixel = megapixel;
		this.connectivity = connectivity;
		this.displaysize = displaysize;
		this.framesPerSecond = framesPerSecond;
		this.lensType = lensType;
		this.madeBy = madeBy;
	}

	@Override
	public String toString() {
		return "CameraEntity [id=" + id + ", name=" + name + ", brand=" + brand + ", model=" + model + ", megapixel="
				+ megapixel + ", connectivity=" + connectivity + ", Displaysize=" + displaysize + ", FramesPerSecond="
				+ framesPerSecond + ", LensType=" + lensType + ", madeBy=" + madeBy + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lensType == null) ? 0 : lensType.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
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
		CameraEntity other = (CameraEntity) obj;
		if (lensType == null) {
			if (other.lensType != null)
				return false;
		} else if (!lensType.equals(other.lensType))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		return true;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getMegapixel() {
		return megapixel;
	}

	public void setMegapixel(double megapixel) {
		this.megapixel = megapixel;
	}

	public boolean isConnectivity() {
		return connectivity;
	}

	public void setConnectivity(boolean connectivity) {
		this.connectivity = connectivity;
	}

	public double getDisplaysize() {
		return displaysize;
	}

	public void setDisplaysize(double displaysize) {
		this.displaysize = displaysize;
	}

	public int getFramesPerSecond() {
		return framesPerSecond;
	}

	public void setFramesPerSecond(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}

	public String getLensType() {
		return lensType;
	}

	public void setLensType(String lensType) {
		this.lensType = lensType;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

}
