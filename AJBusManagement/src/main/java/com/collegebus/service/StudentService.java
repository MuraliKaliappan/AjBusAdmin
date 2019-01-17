package com.collegebus.service;

import com.collegebus.entity.StudentEntity;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.RegistrationModel;

public interface StudentService {

	public void saveRegistration(RegistrationModel registration);
	
	public void saveBusTrip(BusTripSelectionModel busTrip);
	
	public StudentEntity getStudentByEmail(String emailId);
	
}
