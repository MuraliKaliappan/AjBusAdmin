package com.collegebus.dao;

import java.util.List;

import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.RouteCostEntity;

public interface AdminDao {

	public AdminEntity getAdminByUserName(String userName);

	public List<BusTripEntity> getPendingBusTrip();
	
	public List<BusTripEntity> getFinalStatusOfBusTrip();
	
	public BusTripEntity getBusTripBuSerialNo(Integer serialNo);
	
	public void updateBusStatus(BusTripEntity busTripEntity);

	void saveRouteCost(RouteCostEntity costEntity);

	public List<RouteCostEntity> getAllRouteCost();

	public RouteCostEntity getRouteCost(String route);
	
	
	public void changePassword(AdminEntity adminEntity);
	
	public Integer checkAvailabilityOfBusSeats(String area, String trip);

}