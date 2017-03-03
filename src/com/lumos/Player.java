package com.lumos;

public class Player implements Character {
	private int health;
	private String name;
	
	private int strength;
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	
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
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDx() {
		return dx;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
}