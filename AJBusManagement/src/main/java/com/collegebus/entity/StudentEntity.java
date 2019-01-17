package com.collegebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {

	//For RegistrationModel 	
	@Column(name="student_name", nullable = false)
	private String studentName;
	
	@Column(name="degree", nullable = false)
	private String degree;
	
	@Column(name="studying_year", nullable = false)
	private String studyingYear;
	
	@Id
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password", nullable = false)
	private String password;
	
	//For AdditionalDetailsModel
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="emergency_number")
	private String emergencyNumber;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	//For BusTripSelectionModel
	
	@OneToOne	
	@JoinColumn(name="serial_no")
	private BusTripEntity busTripEntity;
	
	
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmergencyNumber() {
		return emergencyNumber;
	}
	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public BusTripEntity getBusTripEntity() {
		return busTripEntity;
	}
	public void setBusTripEntity(BusTripEntity busTripEntity) {
		this.busTripEntity = busTripEntity;
	}

	
	
}
