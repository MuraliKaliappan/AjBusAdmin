package com.collegebus.service;

import java.util.List;

import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.RouteCostEntity;
import com.collegebus.model.AdminRouteCostModel;
import com.collegebus.model.PasswordChangeModel;

public interface AdminService {

	public AdminEntity getAdminByUserName(String adminUserName);
	public List<BusTripEntity> getPendingBusTrip();
	
	public List<BusTripEntity> getFinalStatusOfBusTrip();
	
	public BusTripEntity getBusTripBySerialNo(Integer serialNo);
	
	public void updateBusStatus(Integer busSerialNo, Boolean status);
	
	public void updateFeeStatus(Integer busSerialNo, Boolean status);

	void saveRouteCost(AdminRouteCostModel adminRouteCostModel);
	
	
	public List<RouteCostEntity> getAllRouteCost();
	
	public void changePassword(PasswordChangeModel passwordChangeModel);
	
	public List checkAvailabilityOfBusSeats(String area, String trip);
}
