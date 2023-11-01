package Basic_functionality;

import Enum.Status;

public class Order {
	private int id = 0;
	private int orderId;
	private int petId;
	private int quantity;
	private Status status;

	public Order(int petId, int quantity) {
		this.orderId = ++id;
		this.petId = petId;
		this.quantity = quantity;
		this.status = Status.PLACED;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderId=" + orderId + ", petId=" + petId + ", quantity=" + quantity + ", status="
				+ status + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public int getPetId() {
		return petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
