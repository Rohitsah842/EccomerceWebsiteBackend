package com.project.EcommerceWebsite.Entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer_Details")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "Native")
	@Column(name="Id")
	private long id;
	
	@Column(name="first name")
	private String fname;
	
	@Column(name="last name", nullable = false)
	private String lname;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="mobile number", nullable = false)
	private String mobileNo;
	
//	@Column(name="Role", nullable = false)
//	@Enumerated(EnumType.STRING)
//	private Role role;

	public Customer(long id, String fname, String lname, String email, String password, String mobileNo) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Sign_up [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", mobileNo=" + mobileNo + "]";
	}
	
	
	

}
