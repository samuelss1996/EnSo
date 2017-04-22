package model.data;


public class SellLine {
	private Product product;
	private int quantity;
	private float unitPrice;
	private float totalPrice;

    public SellLine(Product product, int quantity, float unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

        this.totalPrice = unitPrice * quantity;
    }

    public Product getProduct() {
		return null;
	}
	
	public int getQuantity() {
		return 0;
	}
}
