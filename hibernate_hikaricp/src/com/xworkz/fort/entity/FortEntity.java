package com.xworkz.fort.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fort_table")

public class FortEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "f_id")
	private int id;
	@Column(name = "f_name")
	private String name;
	@Column(name = "f_location")
	private String location;
	@Column(name = "f_unescoHeritageList")
	private boolean unescoHeritageList;

	public FortEntity() {
	}

	public FortEntity(String name, String location, boolean unescoHeritageList) {
		super();
		this.name = name;
		this.location = location;
		this.unescoHeritageList = unescoHeritageList;
	}

	@Override
	public String toString() {
		return "FortEntity [id=" + id + ", name=" + name + ", location=" + location + ", unescoHeritageList="
				+ unescoHeritageList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		FortEntity other = (FortEntity) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isUnescoHeritageList() {
		return unescoHeritageList;
	}

	public void setUnescoHeritageList(boolean unescoHeritageList) {
		this.unescoHeritageList = unescoHeritageList;
	}

}
