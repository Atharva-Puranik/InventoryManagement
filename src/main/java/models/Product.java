package models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productId;
	
	String productName;
	
	String category;
	
	@OneToOne(mappedBy = "product" ,cascade = CascadeType.ALL)
	Inventory inventory;
	
	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	public int getProductId() {
		return productId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(String productName, String category) {
		this.productName = productName;
		this.category = category;
	}
	
	public Product() {
		
	}
	
}
