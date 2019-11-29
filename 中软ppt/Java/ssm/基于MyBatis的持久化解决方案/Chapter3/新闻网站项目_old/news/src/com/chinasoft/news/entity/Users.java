package com.chinasoft.news.entity;

public class Users {

	private int userId;
	private String username;
	private String password;
	private String txUrl;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTxUrl() {
		return txUrl;
	}
	public void setTxUrl(String txUrl) {
		this.txUrl = txUrl;
	}
}
