package org.java.inventory;

public class Inventory {
	private String itemName;
	private double itemCostPrice;
	private double itemSellPrice;
	private int quantity;
	private double itemValue;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCostPrice() {
		return itemCostPrice;
	}
	public void setItemCostPrice(double itemCostPrice) {
		this.itemCostPrice = itemCostPrice;
	}
	public double getItemSellPrice() {
		return itemSellPrice;
	}
	public void setItemSellPrice(double itemSellPrice) {
		this.itemSellPrice = itemSellPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getItemValue() {
		return getItemCostPrice() * getQuantity();
	}

}