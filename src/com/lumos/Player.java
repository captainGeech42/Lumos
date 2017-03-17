package com.lumos;

public class Player extends Character {
	
	private Inventory inventory;
	
	public Player(int health, String name) {
		super(health, name);

		inventory = new Inventory();

		Item waterBottles = new Item(5, "Water Bottle", false, ItemType.CONSUMABLE, 'W');
		inventory.addItem(waterBottles);
	}

	public Inventory getInventory() {
		return inventory;
	}
}