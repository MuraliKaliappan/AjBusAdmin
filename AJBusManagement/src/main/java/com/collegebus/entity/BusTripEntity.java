package com.collegebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="bus_trip")
public class BusTripEntity {
	
	@Id
	@GeneratedValue
	@Column(name="serial_no")
	private Integer serialNo;
	
	
	
	@Column(name="area")
	private String area;
	
	@Column(name="trip")
	private String trip;

	@OneToOne
	@JoinColumn(name="email_id")
	private StudentEntity student;

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}
	

	

}
