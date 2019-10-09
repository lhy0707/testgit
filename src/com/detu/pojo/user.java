package com.detu.pojo;

public class user {
	private String Uid;
	private String username;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String birthday;
	
	
	
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "user [Uid=" + Uid + ", username=" + username + ", password=" + password + ", email=" + email + ", name="
				+ name + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
	
	
	

}
