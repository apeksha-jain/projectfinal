package com.cg.project.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountTransactions {
	
	@Id
	private int id;
	private String username;
	private String transaction;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	
}
