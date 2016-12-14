package com.spmvc.model;
/**
 * 用户表
 * @author mabaoyun
 *
 */
public class Auth_User {
	private int auth_user_id;
	private String auth_user_name;
	private String auth_user_pwd;
	
	public int getAuth_user_id() {
		return auth_user_id;
	}
	public void setAuth_user_id(int auth_user_id) {
		this.auth_user_id = auth_user_id;
	}
	public String getAuth_user_name() {
		return auth_user_name;
	}
	public void setAuth_user_name(String auth_user_name) {
		this.auth_user_name = auth_user_name;
	}
	public String getAuth_user_pwd() {
		return auth_user_pwd;
	}
	public void setAuth_user_pwd(String auth_user_pwd) {
		this.auth_user_pwd = auth_user_pwd;
	}
	
	
}
