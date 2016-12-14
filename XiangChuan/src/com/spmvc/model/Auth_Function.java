package com.spmvc.model;
/**
 * 功能模块管理表
 * @author mabaoyun
 *
 */
public class Auth_Function {

	private int auth_function_id;
	private String auth_function_name;
	private int auth_function_parent_id;
	private String auth_function_url;
	public int getAuth_function_id() {
		return auth_function_id;
	}
	public void setAuth_function_id(int auth_function_id) {
		this.auth_function_id = auth_function_id;
	}
	public String getAuth_function_name() {
		return auth_function_name;
	}
	public void setAuth_function_name(String auth_function_name) {
		this.auth_function_name = auth_function_name;
	}
	public int getAuth_function_parent_id() {
		return auth_function_parent_id;
	}
	public void setAuth_function_parent_id(int auth_function_parent_id) {
		this.auth_function_parent_id = auth_function_parent_id;
	}
	public String getAuth_function_url() {
		return auth_function_url;
	}
	public void setAuth_function_url(String auth_function_url) {
		this.auth_function_url = auth_function_url;
	}
	
	
}
