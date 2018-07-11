package org.java.inventory;

import java.util.Map;
import java.util.TreeMap;

public class InventoryManagementService {
	
	/**
	 * Considering TreeMap as it implements sorting internally
	 */
	private static TreeMap<String, Inventory> inventoryList = new TreeMap<String, Inventory>();
	private static double profitVal = 0;
	
	/**
	 * a) create itemName costPrice sellingPrice
	 * @param inputCommand
	 */
	public static void createItem(String inputCommand) {
		String[] value = inputCommand.split(" ");
		if(value.length == 4 && "create".equalsIgnoreCase(value[0])) {
			Inventory inventory = new Inventory();
			inventory.setItemName(value[1]);
			inventory.setItemCostPrice(Double.parseDouble(value[2]));
			inventory.setItemSellPrice(Double.parseDouble(value[3]));
			inventoryList.put(value[1], inventory);
		} else {
			System.out.println("Entered wrong input command");
		}
	}
	
	/**
	 * c) updateBuy itemName quantity
	 * @param inputCommand
	 */
	public static void updateBuyItem(String inputCommand) {
		String[] value = inputCommand.split(" ");
		if(value.length == 3 && "updateBuy".equalsIgnoreCase(value[0])) {
			Inventory inventory = inventoryList.get(value[1]);
			inventory.setQuantity(Integer.parseInt(value[2]));
			inventoryList.put(value[1], inventory);
		} else {
			System.out.println("Entered wrong input command");
		}
	}
	
	/**
	 * d) updateSell itemName quantity
	 * @param inputCommand
	 */
	public static void updateSellItem(String inputCommand) {
		String[] value = inputCommand.split(" ");
		if(value.length == 3 && "updateSell".equalsIgnoreCase(value[0])) {
			Inventory inventory = inventoryList.get(value[1]);
			profitVal += (inventory.getItemSellPrice() - inventory.getItemCostPrice()) * Double.parseDouble(value[2]);
			inventory.setQuantity(inventory.getQuantity() - Integer.parseInt(value[2]));
			inventoryList.put(value[1], inventory);

		} else {
			System.out.println("Entered wrong input command");
		}
	}
	
	/**
	 * b) delete itemName
	 * @param inputCommand
	 */
	public static void deleteItem(String inputCommand) {
		String[] value = inputCommand.split(" ");
		if(value.length == 2 && "delete".equalsIgnoreCase(value[0])) {
			Inventory inventory = inventoryList.get(value[1]);
			profitVal = profitVal - (inventory.getItemCostPrice() * inventory.getQuantity()); 
			inventoryList.remove(value[1]);
		} else {
			System.out.println("Entered wrong input command");
		}
	}
	
	/**
	 * e) report
	 */
	public static void report() {
		double totalVal = 0.00;
		System.out.println("\t\t\t INVENTORY REPORT");
		System.out.printf("%-18s%-18s%-18s%-18s%-18s\n", "Item Name", "Bought At", "Sold At", "AvailableQty", "Value");
		System.out.printf("%-18s%-18s%-18s%-18s%-18s\n", "---------", "---------", "-------", "------------", "-----");
		for(Map.Entry<String, Inventory> inventory : inventoryList.entrySet()) {
			totalVal += inventory.getValue().getItemValue();
			System.out.printf("%-18s%-18.2f%-18.2f%-18d%-18.2f\n", inventory.getValue().getItemName(), inventory.getValue().getItemCostPrice(), 
					inventory.getValue().getItemSellPrice(), inventory.getValue().getQuantity(), inventory.getValue().getItemValue());
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.printf("Total Value" +"%65.2f",totalVal);
		System.out.printf("\nProfit since previous report" +"%50.2f",profitVal);
		profitVal = 0;
	}
	
}