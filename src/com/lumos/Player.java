package com.lumos;

public class Player implements Character {
	private int health;
	private String name;
	
	private int strength;
	
	private Inventory inventory;
	
	public Player(int health, String name) {
		this.health = health;
		this.name = name;
		
		inventory = new Inventory();

		Item waterBottles = new Item(5, "Water Bottle", false, ItemType.CONSUMABLE);
		inventory.addItem(waterBottles);
	}
	
	@Override
	public int getHealth() {
		return health;
	}
	
	@Override
	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;		
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
}