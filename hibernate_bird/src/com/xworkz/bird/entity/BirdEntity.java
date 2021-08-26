package com.xworkz.bird.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bird_table")

public class BirdEntity implements Serializable {

	@Id
	@Column(name = "b_id")
	private int id;
	@Column(name = "b_name")
	private String name;
	@Column(name = "b_color")
	private String color;
	@Column(name = "b_migrate")
	private boolean migrate;
	@Column(name = "b_stateBird")
	private boolean stateBird;
	@Column(name = "b_vegetarian")
	private boolean vegetarian;
	@Column(name = "b_lifeSpan")
	private int lifeSpan;
	@Column(name = "b_family")
	private String family;
	@Column(name = "b_mostlyFoundIn")
	private String mostlyFoundIn;
	@Column(name = "b_beautiful")
	private boolean beautiful;

	public BirdEntity() {
	}

	public BirdEntity(int id, String name, String color, boolean migrate, boolean stateBird, boolean vegetarian,
			int lifeSpan, String family, String mostlyFoundIn, boolean beautiful) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.migrate = migrate;
		this.stateBird = stateBird;
		this.vegetarian = vegetarian;
		this.lifeSpan = lifeSpan;
		this.family = family;
		this.mostlyFoundIn = mostlyFoundIn;
		this.beautiful = beautiful;
	}

	@Override
	public String toString() {
		return "BirdEntity [id=" + id + ", name=" + name + ", color=" + color + ", migrate=" + migrate + ", stateBird="
				+ stateBird + ", vegetarian=" + vegetarian + ", lifeSpan=" + lifeSpan + ", family=" + family
				+ ", mostlyFoundIn=" + mostlyFoundIn + ", beautiful=" + beautiful + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((family == null) ? 0 : family.hashCode());
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
		BirdEntity other = (BirdEntity) obj;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isMigrate() {
		return migrate;
	}

	public void setMigrate(boolean migrate) {
		this.migrate = migrate;
	}

	public boolean isStateBird() {
		return stateBird;
	}

	public void setStateBird(boolean stateBird) {
		this.stateBird = stateBird;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegaterian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public int getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getMostlyFoundIn() {
		return mostlyFoundIn;
	}

	public void setMostlyFoundIn(String mostlyFoundIn) {
		this.mostlyFoundIn = mostlyFoundIn;
	}

	public boolean isBeautiful() {
		return beautiful;
	}

	public void setBeautiful(boolean beautiful) {
		this.beautiful = beautiful;
	}

}
