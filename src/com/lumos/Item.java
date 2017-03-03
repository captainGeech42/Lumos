package com.lumos;

public class Item {
	
	private int strength;
	private int durability;
	private String name;
	private boolean isUnique;
	private ItemType type;
	
	public Item(int durability, String name, boolean isUnique, ItemType type) {
		this.durability = durability;
		this.name = name;
		this.isUnique = isUnique;
		this.type = type;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isUnique() {
		return isUnique;
	}
	
	public ItemType getType() {
		return type;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public void setDurability(int durability) {
		this.durability = durability;
	}
}