package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int customerId;
	@NotEmpty(message = "First name required")
	private	String firstName;
	@NotEmpty(message = "Last name required")
	private	String lastName;
	@NotEmpty(message = "Address required")
	private	String address;
	
	@NotEmpty(message = "Phone number required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="Mobile number invalid")
	private String phone;
	@NotEmpty(message = "Email required")
    @Email(message = "Please enter a valid email address")
	private	String emailId;
	
	public Customer() {}
	
	public Customer(int customerId, String firstName, String lastName, String address, String phone, String emailId) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.emailId = emailId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phone=" + phone + ", emailId=" + emailId + "]";
	}
}
