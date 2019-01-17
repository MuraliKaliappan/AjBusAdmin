package com.collegebus.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegebus.dao.AdminDao;
import com.collegebus.entity.AdminEntity;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AdminEntity getAdminByUserName(String adminUserName) {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AdminEntity.class);
		
		AdminEntity adminEntity = (AdminEntity) criteria.add(Restrictions.eq("adminName",adminUserName )).uniqueResult();
		 
		return adminEntity;
	}

}
