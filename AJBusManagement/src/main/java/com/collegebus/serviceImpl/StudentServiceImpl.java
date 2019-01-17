package com.collegebus.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegebus.dao.StudentDao;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.RegistrationModel;
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
	
	
}
