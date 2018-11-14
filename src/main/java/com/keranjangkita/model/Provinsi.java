package com.keranjangkita.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Provinsi {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id_provinsi")
    private String idProvinsi;
	@Column(name="name")
	private String name;

	public String getIdProvinsi() {
		return idProvinsi;
	}

	public void setIdProvinsi(String idProvinsi) {
		this.idProvinsi = idProvinsi;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
