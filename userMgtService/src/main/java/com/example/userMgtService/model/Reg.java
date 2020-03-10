package com.example.userMgtService.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="Reg")
public class Reg {
	//Attiributes
		@GeneratedValue @Id
		private int id;
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		//@DateTimeFormat(pattern = "MM-dd-yyyy")
		@Column(name="DOB")
		private Date DOB ;
		
		@Column(name="gender")
		private String gender ;
		
		@Column(name="user_name")
		private String userName;

		@Column(name="pass_word")
		private String password;
		
		@Column(name="position")
		private String position;
		
		@Column(name="orgName")
		private String orgName;
		
		@Column(name="contactNo")
		private int contactNo ;
		//Getters and Setters
		
		
		
		@Column(name="role_Type")
		private String role_Type;
		
   		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public Date getDOB() {
			return DOB;
		}

		public void setDOB(Date dOB) {
			DOB = dOB;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole_Type() {
			return role_Type;
		}

		public void setRole_Type(String role_Type) {
			this.role_Type = role_Type;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public String getOrgName() {
			return orgName;
		}

		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}

		public int getContactNo() {
			return contactNo;
		}

		public void setContactNo(int contactNo) {
			this.contactNo = contactNo;
		}

		

		
		
}
