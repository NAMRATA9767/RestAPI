package com.example.apirest.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@EntityListeners(AuditingEntityListener.class)

public class StudentTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
@NotBlank
@NotNull(message="Name is required")
@Size(max=20,message="max 20 characters allowed")
@Pattern(regexp = "[a-zA-Z]+",message="Only characters allowed")
	private String name;
@Pattern(regexp = "[a-zA-Z]+",message="Only characters allowed")
@NotBlank
	private String city;
@NotNull(message="Email is required")
@Email(message="PLease enter valid email ADdress")
	private String email;
@NotBlank(message="password must not be blank")
@Size(min=6,max=20)
@Pattern(regexp = "[a-zA-Z0-9]+",message="Only alphanumeric allowed")
	private String password;

@CreatedDate
@Column(nullable = false,updatable = false)
private LocalDateTime createDate;

@LastModifiedDate
@Column(insertable = false)
private LocalDateTime lastModified;
public StudentTable() {
	
}
	public StudentTable(Integer id, String name, String city, String email, String password) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.email = email;
	this.password = password;
}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password=" + password
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getCity()=" + getCity() + ", getEmail()="
				+ getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
}
