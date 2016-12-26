package com.yj.yjsite.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class UsersVo {
	private int no;
	private String id;

	@NotEmpty
	private String password;
	
	private String usersImage;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsersImage() {
		return usersImage;
	}

	public void setUsersImage(String usersImage) {
		this.usersImage = usersImage;
	}

	@Override
	public String toString() {
		return "UsersVo [no=" + no + ", id=" + id + ", password=" + password + ", usersimage=" + usersImage + "]";
	}

}
