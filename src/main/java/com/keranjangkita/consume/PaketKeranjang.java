package com.keranjangkita.consume;

import java.util.ArrayList;
import java.util.List;

public class PaketKeranjang {

	List<ItemContent> paketKeranjang;

	public PaketKeranjang() {
		paketKeranjang = new ArrayList();
	}
	
	public List<ItemContent> getPaketKeranjang() {
		return paketKeranjang;
	}

	public void setPaketKeranjang(List<ItemContent> paketKeranjang) {
		this.paketKeranjang = paketKeranjang;
	}
	
}
