package com.xworkz.soap.dto;

import com.xworkz.soap.constant.SoapType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "soap_table")
public class SoapDTO implements Serializable {
	@Column(name="s_id")
	private int id;
	@Column(name="s_brandAmbassador")
	private String brandAmbassador;
	@Column(name="s_odour")
	private String odour;
	@Column(name="s_certified")
    private boolean certified;
	@Column(name="s_AntiBacteria")
    private boolean AntiBacteria;
	@Column(name="s_type")
    private SoapType type;

	public SoapDTO() {
	}

	public SoapDTO(int id, String brandAmbassador, String odour, boolean certified, boolean antiBacteria,
			SoapType type) {
		super();
		this.id = id;
		this.brandAmbassador = brandAmbassador;
		this.odour = odour;
		this.certified = certified;
		AntiBacteria = antiBacteria;
		this.type = type;
	}

	@Override
	public String toString() {
		return "SoapDTO [id=" + id + ", brandAmbassador=" + brandAmbassador + ", odour=" + odour + ", certified="
				+ certified + ", AntiBacteria=" + AntiBacteria + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SoapDTO other = (SoapDTO) obj;
		if (id != other.id)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandAmbassador() {
		return brandAmbassador;
	}

	public void setBrandAmbassador(String brandAmbassador) {
		this.brandAmbassador = brandAmbassador;
	}

	public String getOdour() {
		return odour;
	}

	public void setOdour(String odour) {
		this.odour = odour;
	}

	public boolean isCertified() {
		return certified;
	}

	public void setCertified(boolean certified) {
		this.certified = certified;
	}

	public boolean isAntiBacteria() {
		return AntiBacteria;
	}

	public void setAntiBacteria(boolean antiBacteria) {
		AntiBacteria = antiBacteria;
	}

	public SoapType getType() {
		return type;
	}

	public void setType(SoapType type) {
		this.type = type;
	}

}
