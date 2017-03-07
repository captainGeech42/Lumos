package com.lumos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
	private ArrayList<Item> items;
	public final ReentrantLock hasNewItemsLock = new ReentrantLock();
	public boolean hasNewItems = false;

	public Inventory() {
		items = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		items.add(item);
		hasNewItemsLock.lock();
		hasNewItems = true;
		hasNewItemsLock.unlock();
	}
	
	public Iterator<Item> getIterator() {
		return items.iterator();
	}
}
