package com.collegebus.daoImpl;

import java.util.List;

import org.hibernate.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegebus.dao.AdminDao;
import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.RouteCostEntity;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AdminEntity getAdminByUserName(String adminUserName) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AdminEntity.class);
		
		AdminEntity adminEntity = (AdminEntity) criteria.add(Restrictions.eq("adminName",adminUserName )).uniqueResult();
		 
		return adminEntity;
	}

	@Override
	public List<BusTripEntity> getPendingBusTrip() {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BusTripEntity.class);
		List<BusTripEntity> busTripEntities = (List<BusTripEntity>) criteria.add(Restrictions.eq("pendingStatus",true )).list();
		 
		return busTripEntities;
	}
	
	@Override
	public BusTripEntity getBusTripBuSerialNo(Integer serialNo) {
		BusTripEntity busTripEntity = (BusTripEntity) sessionFactory.getCurrentSession().get(BusTripEntity.class, serialNo);
		
		return busTripEntity;
	}

	@Override
	public void updateBusStatus(BusTripEntity busTripEntity) {

		sessionFactory.getCurrentSession().update(busTripEntity);
	}

	@Override
	public void saveRouteCost(RouteCostEntity costEntity) {
		sessionFactory.getCurrentSession().saveOrUpdate(costEntity);
	}

	@Override
	public List<RouteCostEntity> getAllRouteCost() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RouteCostEntity.class);
		List<RouteCostEntity> routeCosts =  (List<RouteCostEntity>) criteria.list();
		return routeCosts;
	}

	@Override
	public RouteCostEntity getRouteCost(String route) {
		// TODO Auto-generated method stub
		
		RouteCostEntity routeCost = (RouteCostEntity)sessionFactory.getCurrentSession().get(RouteCostEntity.class, route);
		return routeCost;
		
	}

	@Override
	public void changePassword(AdminEntity adminEntity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(adminEntity);;
	}

	@Override
	public List<BusTripEntity> getFinalStatusOfBusTrip() {
		// TODO Auto-generated method stub
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BusTripEntity.class);
		List<BusTripEntity> busTripEntities = (List<BusTripEntity>) criteria.add(Restrictions.eq("finalStatus",true )).list();
		return busTripEntities;
	}

	@Override
	public Integer checkAvailabilityOfBusSeats(String route, String tripNo) {		
		Query q = (Query) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(serialNo) FROM BusTripEntity busTrip WHERE finalStatus = true AND area = '"+route+"' AND trip = '"+tripNo+"'");
		Long list = (Long) q.uniqueResult();
		Integer allotedBusSeats = list.intValue();
		return allotedBusSeats;
	}

}
