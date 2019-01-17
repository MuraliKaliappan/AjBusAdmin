package com.collegebus.model;

public class RegistrationModel {

	
	
	private String studentName;
	
	private String degree;
	
	private String studyingYear;
	
	private String emailId;
	
	private String password;
	
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String getStudyingYear() {
		return studyingYear;
	}
	public void setStudyingYear(String studyingYear) {
		this.studyingYear = studyingYear;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
