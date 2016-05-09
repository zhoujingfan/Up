package com.up.auth.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

    private String message;

    @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
    	message = "Hello from struts2!";
		return SUCCESS;
	}


	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}


    public void setMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }


}