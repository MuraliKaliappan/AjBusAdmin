package com.collegebus.service;

import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;
import com.collegebus.model.AdditionalDetailsModel;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.PasswordChangeModel;
import com.collegebus.model.RegistrationModel;
import com.collegebus.model.UpdateModel;

public interface StudentService {

	public void saveRegistration(RegistrationModel registration);
	
	
	
	public void saveAdditionalDetails(AdditionalDetailsModel additionalDetailsModel);
	
	public void changePassword(PasswordChangeModel passwordChangeModel);
	
	public void update(UpdateModel updateModel);
	
	public StudentEntity getStudentByEmail(String emailId);
	
	//bus trip service
	
	public void saveBusTrip(BusTripSelectionModel busTrip);
	
	public BusTripEntity getBusTripByStudentEmail(String emailId);
	
}
