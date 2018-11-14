package com.keranjangkita.consume;

import java.util.ArrayList;
import java.util.List;

import com.keranjangkita.model.Item;

public class ItemContent {

	private List<Item> content;
	
	public ItemContent() {
		this.content = new ArrayList();
	}

	public List<Item> getContent() {
		return content;
	}

	public void setContent(List<Item> content) {
		this.content = content;
	}
}
