package com.he.shoppingCart;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {
	Cart cart;

	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
		cart.addItem(new Product("apple", 90D), 3);
		cart.addItem(new Product("banana", 30D), 6);
		cart.addItem(new Product("banana", 30D), 6);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCart() {
		fail("Not yet implemented");
	}

	@Test
	void testAddItem() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveItem() {
		fail("Not yet implemented");
	}

	@Test
	void testGenerateInvoice() {
		cart.generateInvoice();
	}

	@Test
	void testCheckOut() {
		fail("Not yet implemented");
	}

	@Test
	void testEmptyCart() {
		fail("Not yet implemented");
	}

}
