package com.yujin.spring.jdbc;

public class User {

	private int id;
	private String username;
	private String pwd;
	
	public User() {
		
	}
	
	public User(int _id, String _username, String _pwd) {
		this.id = _id;
		this.username = _username;
		this.pwd = _pwd;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.id + "|" + this.username + "|" +this.pwd +"]";
	}
}
