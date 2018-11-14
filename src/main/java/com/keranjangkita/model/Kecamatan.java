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

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Kecamatan {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id_kecamatan")
    private String idKecamatan;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="id_kabupaten")
	private Kabupaten kabupaten;

	public String getIdKecamatan() {
		return idKecamatan;
	}

	public void setIdKecamatan(String idKecamatan) {
		this.idKecamatan = idKecamatan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kabupaten getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(Kabupaten kabupaten) {
		this.kabupaten = kabupaten;
	}
}
