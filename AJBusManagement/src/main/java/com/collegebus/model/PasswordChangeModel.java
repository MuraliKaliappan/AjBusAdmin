package com.collegebus.model;

public class PasswordChangeModel {

	private String studentMail;
	
	private String old;
	
	private String newPwd;
	
	private String confirm;
	
	public String getStudentMail() {
		return studentMail;
	}

	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
}
