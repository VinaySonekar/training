package com.vs.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="custdata")
public class Customer {
	
	@Id
	@Column(name="cust_no")
	private int custId;
	
	@Column(name="cust_name",length=20)
	private String custName;
	
	@Column(name="cust_city",length=30)
	private String city;
	
	public Customer() {
		
	}
	public Customer(int custId, String custName, String city) {
		
		this.custId = custId;
		this.custName = custName;
		this.city = city;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
