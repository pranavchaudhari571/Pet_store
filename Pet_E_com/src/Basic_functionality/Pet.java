package Basic_functionality;

import Enum.Category;

public class Pet {

	private int petId;
	private String name;
	private Category category;
	private double unitPrice;
	private int stocks;

	public Pet(int petId, String name, Category category, double unitPrice, int stocks) {
		this.petId = petId;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.stocks = stocks;
	}

	public int getPetId() {
		return petId;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getStocks() {
		return stocks;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitPrice=" + unitPrice
				+ ", stocks=" + stocks + "]";
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
