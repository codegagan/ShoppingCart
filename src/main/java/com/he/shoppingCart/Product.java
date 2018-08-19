package com.he.shoppingCart;

public class Product {
	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name == null ? "" : name;
		this.price = price == null ? 0d : price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;

		return this.name.equalsIgnoreCase(other.getName()) && this.price.equals(other.getPrice());
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());

		int priceHash = 0;
		if (price != null) {
			long priceLong = Double.doubleToLongBits(price);
			priceHash = (int) (priceLong ^ (priceLong >>> 32));
		}
		result = (prime * result + priceHash);
		return result;
	}

}
