package com.project.EcommerceWebsite.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
	
	@NotNull
	private String fname;
	@NotNull
	private String lname;
	@NotNull
	@Email
	private String email;
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,16}$", message="Invailid password")
	private String password;
	@Pattern(regexp="^\\d{10}$",message="Invailid Mobile number")
	private String mobileNo;
	
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,16}$", message="Invailid confirm password")
	private String confirmPassword;
	
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
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public SignUpDto(String fname, String lname, String email, String password,String confirmPassword, String mobileNo) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.confirmPassword=confirmPassword;
		this.mobileNo = mobileNo;
	}
	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SignUpDto [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	
	

}
