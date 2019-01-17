package com.collegebus.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebus.dao.StudentDao;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;
import com.collegebus.model.AdditionalDetailsModel;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.PasswordChangeModel;
import com.collegebus.model.RegistrationModel;
import com.collegebus.model.UpdateModel;
import com.collegebus.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	StudentEntity student ;
	
	@Override
	public void saveRegistration(RegistrationModel registration) {
		
		student = new StudentEntity();
		
		student.setStudentName(registration.getStudentName());
		student.setDegree(registration.getDegree());
		student.setStudyingYear(registration.getStudyingYear());
		student.setEmailId(registration.getEmailId());
		student.setPassword(registration.getPassword());
		
		studentDao.saveRegistration(student);
		
	}

	@Override
	public StudentEntity getStudentByEmail(String emailId) {
	
		return studentDao.getStudentById(emailId);
	}

	@Override
	public void saveBusTrip(BusTripSelectionModel busTrip) {
		// TODO Auto-generated method stub
		
		BusTripEntity busTripEntity =  new BusTripEntity();
		
		StudentEntity studentEntity = studentDao.getStudentById(busTrip.getStudentMail());
		
		busTripEntity.setArea(busTrip.getArea());
		busTripEntity.setTrip(busTrip.getTrip());
		busTripEntity.setStudent(studentEntity);
		
		studentDao.saveBusTripSelection(busTripEntity);
		
	}

	@Override
	public void saveAdditionalDetails(AdditionalDetailsModel additionalDetailsModel) {
		// TODO Auto-generated method stub
		
		StudentEntity studentEntity = getStudentByEmail(additionalDetailsModel.getStudentMail());
		
		studentEntity.setDateOfBirth(additionalDetailsModel.getDateOfBirth());
		studentEntity.setBloodGroup(additionalDetailsModel.getBloodGroup());
		studentEntity.setEmergencyNumber(additionalDetailsModel.getEmergencyNumber());
		studentEntity.setMobileNumber(additionalDetailsModel.getMobileNumber());
		
		
		studentDao.saveAdditionalDetails(studentEntity);
	}

	

	
	@Override
	public void changePassword(PasswordChangeModel passwordChangeModel){
		// TODO Auto-generated method stub
		
		StudentEntity studentEntity = studentDao.getStudentById(passwordChangeModel.getStudentMail());
		
		studentEntity.setPassword(passwordChangeModel.getNewPwd());
		
		studentDao.changePassword(studentEntity);
	
	}

	@Override
	public void update(UpdateModel updateModel) {
		// TODO Auto-generated method stub
		
		StudentEntity studentEntity = studentDao.getStudentById(updateModel.getStudentMail());
		
		studentEntity.setStudentName(updateModel.getName());
		studentEntity.setDegree(updateModel.getDegree());
		studentEntity.setStudyingYear(updateModel.getYearOfStudying());
		
		studentEntity.setDateOfBirth(updateModel.getDob());
		studentEntity.setBloodGroup(updateModel.getBloodGroup());
		studentEntity.setEmergencyNumber(updateModel.getEmergency());
		studentEntity.setMobileNumber(updateModel.getMob());
		
		
		studentDao.update(studentEntity);
	
	}
	
	
}
