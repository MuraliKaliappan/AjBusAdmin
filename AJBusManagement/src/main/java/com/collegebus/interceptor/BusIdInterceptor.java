package com.collegebus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.collegebus.entity.StudentEntity;
import com.collegebus.service.StudentService;

public class BusIdInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private StudentService studentService;
	
	private String emailId;
	
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		StudentEntity studentEntity = studentService.getStudentByEmail(emailId);
		if((studentEntity.getBloodGroup() != null) && (studentEntity.getEmergencyNumber() != null) && (studentEntity.getMobileNumber() != null))
			return true;
		else
			return false;
	}
	
}
