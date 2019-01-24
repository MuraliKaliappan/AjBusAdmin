package com.collegebus.serviceImpl;

import java.util.List;

import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebus.dao.AdminDao;
import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.RouteCostEntity;
import com.collegebus.model.AdminRouteCostModel;
import com.collegebus.model.PasswordChangeModel;
import com.collegebus.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public AdminEntity getAdminByUserName(String adminUserName) {
		// TODO Auto-generated method stub
		AdminEntity adminEntity = (AdminEntity) adminDao.getAdminByUserName(adminUserName);
		return adminEntity;
	}

	@Override
	public List<BusTripEntity> getPendingBusTrip() {		
		return adminDao.getPendingBusTrip();
	}

	@Override
	public void updateBusStatus(Integer busSerialNo, Boolean status) {
		
		BusTripEntity busTripEntity = getBusTripBySerialNo(busSerialNo);
		busTripEntity.setPendingStatus(false);
		busTripEntity.setFinalStatus(status);
		if(status == true) {
			/*RouteCostEntity costEntity = getRouteCostByRoute(busTripEntity.getArea());
			busTripEntity.setRouteCost(costEntity.getAmount());*/
			
			RouteCostEntity costEntity = adminDao.getRouteCost(busTripEntity.getArea());
			busTripEntity.setRouteCostEntity(costEntity);
		}
				
		adminDao.updateBusStatus(busTripEntity);
		
	}

	@Override
	public BusTripEntity getBusTripBySerialNo(Integer serialNo) {
		// TODO Auto-generated method stub
		return adminDao.getBusTripBuSerialNo(serialNo);
	}

	/*@Override
	public void saveRouteCost(RouteCost routeCosts) {
		
		for(AdminRouteCostModel adminRouteCostModel :routeCosts.getAdminRouteCostModels()) {
			
			RouteCostEntity costEntity = new RouteCostEntity();
			costEntity.setRouteName(adminRouteCostModel.getRouteName());
			costEntity.setAmount(adminRouteCostModel.getAmount());
			
			adminDao.saveRouteCost(costEntity);
			
		}		
	}

	@Override*/
	public List<RouteCostEntity> getAllRouteCost() {
		// TODO Auto-generated method stub
		return adminDao.getAllRouteCost();
	}
	
	
	public RouteCostEntity getRouteCostByRoute(String route) {
		return adminDao.getRouteCost(route);
	}

	@Override
	public void changePassword(PasswordChangeModel passwordChangeModel) {
		// TODO Auto-generated method stub
		
		AdminEntity adminEntity = adminDao.getAdminByUserName(passwordChangeModel.getUserName());
		
		adminEntity.setAdminPassword(passwordChangeModel.getNewPwd());
		
		adminDao.changePassword(adminEntity);
	
	}

	@Override
	public void saveRouteCost(AdminRouteCostModel adminRouteCostModel) {
		// TODO Auto-generated method stub
		RouteCostEntity routeCostEntity = new RouteCostEntity();
		routeCostEntity.setRouteName(adminRouteCostModel.getRouteName());
		routeCostEntity.setAmount(adminRouteCostModel.getAmount());
		adminDao.saveRouteCost(routeCostEntity);
	}

	@Override
	public List<BusTripEntity> getFinalStatusOfBusTrip() {
		// TODO Auto-generated method stub
		
		return adminDao.getFinalStatusOfBusTrip();

	}

	@Override
	public void updateFeeStatus(Integer busSerialNo, Boolean status) {
		// TODO Auto-generated method stub
		
		BusTripEntity busTripEntity = getBusTripBySerialNo(busSerialNo);
		
		busTripEntity.setFinalStatus(false);
		busTripEntity.setFeeStatus(status);
					
		adminDao.updateBusStatus(busTripEntity);
	
		
	}

	

	@Override
	public List checkAvailabilityOfBusSeats(String area, String trip) {
		// TODO Auto-generated method stub
		return adminDao.checkAvailabilityOfBusSeats(area,trip);
	}
}
