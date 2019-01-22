package com.collegebus.dao;

import java.util.List;

import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.RouteCostEntity;
import com.collegebus.entity.StudentEntity;
import com.collegebus.model.RouteCost;

public interface AdminDao {

	public AdminEntity getAdminByUserName(String userName);

	public List<BusTripEntity> getPendingBusTrip();
	
	public BusTripEntity getBusTripBuSerialNo(Integer serialNo);
	
	public void updateBusStatus(BusTripEntity busTripEntity);

	void saveRouteCost(RouteCostEntity costEntity);

	public List<RouteCostEntity> getAllRouteCost();

	public RouteCostEntity getRouteCost(String route);
	
	
	public void changePassword(AdminEntity adminEntity);

}