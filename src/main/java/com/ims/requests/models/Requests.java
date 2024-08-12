package com.ims.requests.models;

import javax.persistence.*;

@Entity
public class Requests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int requestId;
	int productId;
	int quantity;
	public Requests() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Requests(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
