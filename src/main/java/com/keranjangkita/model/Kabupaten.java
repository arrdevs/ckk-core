package com.keranjangkita.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="kabupaten_kota")
public class Kabupaten {
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id_kabupaten")
    private String idKabupaten;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="id_provinsi")
	private Provinsi provinsi;

	public String getIdKabupaten() {
		return idKabupaten;
	}

	public void setIdKabupaten(String idKabupaten) {
		this.idKabupaten = idKabupaten;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Provinsi getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Provinsi provinsi) {
		this.provinsi = provinsi;
	}
}
