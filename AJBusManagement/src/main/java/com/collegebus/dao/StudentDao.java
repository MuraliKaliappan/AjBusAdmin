package com.collegebus.dao;

import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;

public interface StudentDao {

	public void saveRegistration(StudentEntity studentEntity);
	
	public StudentEntity getStudentById(String emailId);
	
	public void saveBusTripSelection(BusTripEntity busTripEntity);
	
	public void saveAdditionalDetails(StudentEntity studentEntity);
	
	public void changePassword(StudentEntity studentEntity);
	
	public void update(StudentEntity studentEntity);

	public BusTripEntity getBustTripByStudentEmail(String emaildId);
}
