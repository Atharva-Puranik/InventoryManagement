package models;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int inventory_id;
	
	int quantity;
	
	@OneToOne
	Product product;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Inventory(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}
	
	public Inventory() {
		
	}
	
	

}
