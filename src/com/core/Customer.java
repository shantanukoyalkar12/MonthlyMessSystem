package com.core;

import java.time.LocalDate;
import java.util.Objects;

public class Customer {
	//Customer id(int) , first name(String), last name (String), email(String), password(String), 
	//Address String, RegisterDate(LocalDate), planEndDate(LocalDate), Address(String), 
	//Phone No(String),plan Enum, final_amount double

	private int id;
	private String name,email,password,address;
	private LocalDate registerDate;
	private LocalDate planEndDate;
	private String phoneno;
	private MessPlan plan;
	double final_ammount;
	public Customer(int id, String name, String email, String password, String address, String phoneno, MessPlan plan) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.plan = plan;
		this.registerDate =LocalDate.now();
		this.planEndDate = getDateAfter(plan);
		this.phoneno = phoneno;
		this.final_ammount =plan.getCost();
	}

	public Customer(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public MessPlan getPlan() {
		return plan;
	}

	public void setPlan(MessPlan plan) {
		this.plan = plan;
	}

	public double getFinal_ammount() {
		return final_ammount;
	}

	public void setFinal_ammount(double final_ammount) {
		this.final_ammount = final_ammount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", registerDate=" + registerDate + ", planEndDate=" + planEndDate + ", phoneno=" + phoneno
				+ ", plan=" + plan + ", final_ammount=" + final_ammount + "]";
	}
	public LocalDate getDateAfter(MessPlan plan) {
		LocalDate date=null;
		if(plan==MessPlan.YEARLY) {
			date=this.registerDate.plusMonths(12);
		}
		else if(plan==MessPlan.HALFYEAR) {
			date=this.registerDate.plusMonths(6);
		}
		else if(plan==MessPlan.QUARTERLY) {
			date=this.registerDate.plusMonths(3);
		}
		else{
			date=this.registerDate.plusMonths(1);
		}
		return date;
	}
	
	
}
