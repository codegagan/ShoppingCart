package com.he.shoppingCart;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	private final DecimalFormat twoDecimalFormat;

	private Map<Product, Integer> cartItems;

	public Cart() {
		emptyCart();
		twoDecimalFormat = new DecimalFormat(".##");
		twoDecimalFormat.setMinimumFractionDigits(2);
		twoDecimalFormat.setMaximumFractionDigits(2);
	}

	public void addItem(Product product, Integer amount) {
		if (product == null || amount == null) {
			throw new IllegalArgumentException("Null not allowed");
		}
		if (amount < 1) {
			throw new IllegalArgumentException("amount must be greater than 0");
		}

		int previousValue = cartItems.getOrDefault(product, 0);
		cartItems.put(product, previousValue + amount);

	}

	public void removeItem(Product product) {
		if (cartItems.remove(product) == null) {
			throw new UnsupportedOperationException("Product does not exist in cart");
		}
	}

	public void generateInvoice() {
		cartItems.forEach((product, quantity) -> System.out.println(
				product.getName() + " " + quantity + " " + twoDecimalFormat.format(product.getPrice() * quantity)));

		System.out.println("Total price: " + twoDecimalFormat.format(cartItems.entrySet().stream()
				.mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum()));
	}

	public void checkOut() {
		Inventory.getInstance().removeItems(cartItems);
		emptyCart();
	}

	public void emptyCart() {
		cartItems = new HashMap<Product, Integer>();
	}

}
