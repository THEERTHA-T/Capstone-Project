package com.capstone.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Register {

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(32)")
	@Id
	private String adharid;
	private String name;
	private String emailid;
	private String dob;
	private String address;
	@Column(name = "gender")
	private String gender;
	private String phone;
	@Column(name = "typeofuser")
	private String typeOfUser="user";
	public String getAdharid() {
		return adharid;
	}
	public void setAdharid(String adharid) {
		this.adharid = adharid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	@Override
	public String toString() {
		return "Register [adharid=" + adharid + ", name=" + name + ", emailid=" + emailid + ", dob=" + dob
				+ ", address=" + address + ", gender=" + gender + ", phone=" + phone + ", typeOfUser=" + typeOfUser
				+ "]";
	}
	
	
}
