package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_tab")
public class User {

	@Id
	@GeneratedValue(generator = "user_gen")
	@GenericGenerator(name = "user_gen", strategy = "increment")
	@Column(name = "User_Id")
	private int userId;
	@Column(name = "User_Name")
	private String userName;
	@Column(name = "User_Email", unique = true)
	private String userEmail;
	@Column(name = "Password")
	private String userPassword;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_rolls_tab", joinColumns = @JoinColumn(name = "uidFk"))
	@Column(name = "Roll_Name")
	private Set<String> rolls;

	public User() {
		super();
	}

	public User(int userId) {
		super();
		this.userId = userId;
	}

	public User(int userId, String userName, String userEmail, String userPassword, Set<String> rolls) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.rolls = rolls;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<String> getRolls() {
		return rolls;
	}

	public void setRolls(Set<String> rolls) {
		this.rolls = rolls;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", rolls=" + rolls + "]";
	}

}
