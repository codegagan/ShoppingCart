package com.he.shoppingCart;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
	private Map<Product, Integer> productsInventory;
	private static Inventory instance;

	static {
		// Eager creation, Inventory object is always required for application and safe
		// from multiple threads.
		instance = new Inventory();
	}

	private Inventory() {
		productsInventory = new HashMap<Product, Integer>();
	}

	public static Inventory getInstance() {
		return instance;
	}

	public void addItems(Map<Product, Integer> items) {
		if (items.containsValue(0)) {
			throw new IllegalStateException("Products quantity cannot be 0");
		}

		items.forEach((key, value) -> {
			productsInventory.merge(key, value, Math::addExact);
		});
	}

	public void removeItems(Map<Product, Integer> items) {
		if (items.containsValue(0)) {
			throw new IllegalStateException("Products quantity cannot be 0");
		}

		items.forEach((product, quantity) -> {
			if (getAvailableAmount(product) < quantity) {
				throw new UnsupportedOperationException("Not enough products in inventory: " + product.getName());
			}
		});

		// Make the real change
		items.forEach((key, value) -> {
			productsInventory.computeIfPresent(key, (prod, quantity) -> quantity - value);
		});

	}

	public Integer getAvailableAmount(Product product) {
		return productsInventory.getOrDefault(product, 0);
	}

}
