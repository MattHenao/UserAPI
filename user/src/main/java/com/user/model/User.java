package com.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE User SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")

public class User implements Serializable{

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	private Boolean deleted = Boolean.FALSE;
	
	public User(Integer id, String username, String email, String password, Boolean deleted) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.deleted = deleted;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	
	public boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	private static final long serialVersionUID = 1L;
}
