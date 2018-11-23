package edu.scnu.bean;

public class User {
	private Integer user_id;
	private String user_code;
	private String user_name;
	private String user_password;
	private Character user_state;
	private Double account;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Double getAccount() {
		return account;
	}
	public void setAccount(Double account) {
		this.account = account;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Character getUser_state() {
		return user_state;
	}
	public void setUser_state(Character user_state) {
		this.user_state = user_state;
	}
	@Override
	public String toString() {
		return "[user_id=" + user_id + ", user_name=" + user_name + "]";
	}
	public User() {
		super();
	}
	public User(Integer user_id) {
		super();
		this.user_id = user_id;
	}
	public User(Integer user_id, String user_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
	}
	public User(Integer user_id, String user_code, String user_name, String user_password, Character user_state,
			Double account) {
		super();
		this.user_id = user_id;
		this.user_code = user_code;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_state = user_state;
		this.account = account;
	}
	
	
	
}
