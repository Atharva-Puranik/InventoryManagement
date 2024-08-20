package com.ims.requests.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class RequestLogs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int requestLogId;
	int requestId;
	String userName;
	String productName;
	int quantity;
	String status;
	@Temporal(TemporalType.TIMESTAMP)
	LocalDateTime actionTime;
	public RequestLogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestLogs(int requestLogId, int requestId, String userName, String productName, int quantity,
			String status, LocalDateTime actionTime) {
		super();
		this.requestLogId = requestLogId;
		this.requestId = requestId;
		this.userName = userName;
		this.productName = productName;
		this.quantity = quantity;
		this.status = status;
		this.actionTime = actionTime;
	}
	public int getRequestLogId() {
		return requestLogId;
	}
	public void setRequestLogId(int requestLogId) {
		this.requestLogId = requestLogId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getActionTime() {
		return actionTime;
	}
	public void setActionTime(LocalDateTime localDateTime) {
		this.actionTime = localDateTime;
	}
}
