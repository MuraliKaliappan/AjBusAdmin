package com.collegebus.dao;

import com.collegebus.entity.AdminEntity;

public interface AdminDao {

	public AdminEntity getAdminByUserName(String userName);
}
