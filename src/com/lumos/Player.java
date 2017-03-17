package com.lumos;

public class Player extends Character {
	
	private Inventory inventory;
	
	public Player(int health, String name) {
		super(health, name);

		inventory = new Inventory();

		Item waterBottles = new Item(5, "Water Bottle", false, ItemType.CONSUMABLE);
		Item armor = new Item(8, "Cloth Armor", false, ItemType.ARMOR);
		inventory.addItem(waterBottles);
		inventory.addItem(armor);
	}

	public Inventory getInventory() {
		return inventory;
	}
}