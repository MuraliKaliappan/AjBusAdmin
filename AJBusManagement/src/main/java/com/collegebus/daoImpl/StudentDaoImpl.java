package com.collegebus.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegebus.dao.StudentDao;
import com.collegebus.entity.AdminEntity;
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
		sessionFactory.getCurrentSession().save(busTripEntity);
	}
	
	public BusTripEntity getBustTripByStudentEmail(String emailId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BusTripEntity.class);
		StudentEntity entity = getStudentById(emailId);
		BusTripEntity busEntity = (BusTripEntity) criteria.add(Restrictions.eq("student",entity)).uniqueResult();
		 
		return busEntity;	
	}


	@Override
	public void saveAdditionalDetails(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(studentEntity);
	}




	@Override
	public void changePassword(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		

		sessionFactory.getCurrentSession().update(studentEntity);;
		
	}


	@Override
	public void update(StudentEntity studentEntity) {
		// TODO Auto-generated method stub		
		sessionFactory.getCurrentSession().update(studentEntity);
		
	}
	
	
}
