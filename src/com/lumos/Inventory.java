package com.lumos;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
	private ArrayList<Item> items;

	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public Iterator<Item> getIterator() {
		return items.iterator();
	}
}
