package com.up.auth.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;

public class RegisterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String phone;
	private String signature;
	private String address;
	private String nickname;
	private String gender;
	private List<String> genderList;
	// TODO Add file and upload part
	
	public RegisterAction(){
		genderList=new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
	}
	
	/**
	 * 获取userService对象
	 */
	@Autowired
	IUserService userService;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#input()
	 */
	@Override
	public String input() throws Exception {
		return super.input();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String execute() throws Exception {
		try{
			userService.register(getUsername(), getConfirmPassword(), getEmail(), getPhone(), getNickname(), getAddress(), getSignature(), getGender());
			return SUCCESS;
		}
		catch( Exception e){
			return INPUT;
		}
	}
	@Override
	public void validate() {
		if(getPassword()!=null&&getPassword()==getConfirmPassword())addFieldError("confirmPassword","The two passwords are not the same!");
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getGenderList() {
		return genderList;
	}
	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}
	public String inputForRegister(){
		return SUCCESS;
	}
}
	