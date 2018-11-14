package com.keranjangkita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Kelurahan {

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id_kelurahan")
    private String idKelurahan;
	@Column(name="name")
	private String name;
	@Column(name="post_code")
	private String postCode;
	@ManyToOne
	@JoinColumn(name="id_kecamatan")
	private Kecamatan kecamatan;

	public String getIdKelurahan() {
		return idKelurahan;
	}

	public void setIdKelurahan(String idKelurahan) {
		this.idKelurahan = idKelurahan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Kecamatan getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(Kecamatan kecamatan) {
		this.kecamatan = kecamatan;
	}
}
