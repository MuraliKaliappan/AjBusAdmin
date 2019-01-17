package com.collegebus.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegebus.dao.StudentDao;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override	
	public void saveRegistration(StudentEntity studentEntity) {
		sessionFactory.getCurrentSession().save(studentEntity);		
	}

	
	@Override
	public StudentEntity getStudentById(String emailId) {
		
		StudentEntity entity = (StudentEntity) sessionFactory.getCurrentSession().get(StudentEntity.class, emailId);	
		
		return entity;
	}


	@Override
	public void saveBusTripSelection(BusTripEntity busTripEntity) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().save(busTripEntity);
	}
	
	
}
