package com.collegebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	/*@Column(name="bus_fee")
	private Double busFee;
	*/
	/*@Column(name="valid_up_to")
	private String validUpTo;*/

	@Column(name="is_pending")
	private Boolean pendingStatus = true;
	
	@Column(name="final_status")
	private Boolean finalStatus = false;
	
	/*@Column(name="route_cost")
	private Double routeCost;*/
	
	@OneToOne
	@JoinColumn(name="email_id")
	private StudentEntity student;
	
	@ManyToOne
	@JoinColumn(name="route_name")
	private RouteCostEntity routeCostEntity;
	
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

	/*public Double getBusFee() {
		return busFee;
	}

	public void setBusFee(Double busFee) {
		this.busFee = busFee;
	}*/

	/*public String getValidUpTo() {
		return validUpTo;
	}

	public void setValidUpTo(String validUpTo) {
		this.validUpTo = validUpTo;
	}*/

	public Boolean getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(Boolean pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public Boolean getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(Boolean finalStatus) {
		this.finalStatus = finalStatus;
	}

	/*public Double getRouteCost() {
		return routeCost;
	}

	public void setRouteCost(Double routeCost) {
		this.routeCost = routeCost;
	}*/

	public RouteCostEntity getRouteCostEntity() {
		return routeCostEntity;
	}

	public void setRouteCostEntity(RouteCostEntity routeCostEntity) {
		this.routeCostEntity = routeCostEntity;
	}
	
	
	
}
