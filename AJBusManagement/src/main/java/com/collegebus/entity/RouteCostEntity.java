package com.collegebus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="route_cost")
public class RouteCostEntity {

	@GeneratedValue
	@Column(name="serial_no")
	private Integer serialNo;
	
	@Id
	@Column(name="route_name")
	private String routeName;
	
	@Column(name="amount")
	private Double amount;
	
	/*@OneToMany
	@Column(name="serial_no")
	private BusTripEntity busTripEntity;*/
	
	public Integer getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/*public BusTripEntity getBusTripEntity() {
		return busTripEntity;
	}
	public void setBusTripEntity(BusTripEntity busTripEntity) {
		this.busTripEntity = busTripEntity;
	}*/
	
}
