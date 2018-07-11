package org.java.inventory;

import java.util.Scanner;

public class InventoryManagement {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String inputVal = scanner.nextLine();
			if(inputVal.contains("create")) {
				InventoryManagementService.createItem(inputVal);
			} else if(inputVal.contains("updateBuy")) {
				InventoryManagementService.updateBuyItem(inputVal);
			} else if(inputVal.contains("updateSell")) {
				InventoryManagementService.updateSellItem(inputVal);
			} else if(inputVal.contains("delete")) {
				InventoryManagementService.deleteItem(inputVal);
			} else if(inputVal.contains("report")) {
				InventoryManagementService.report();
			} else if(inputVal.contains("exit")) {
				break;
			}
		}
		scanner.close();
	}

}
