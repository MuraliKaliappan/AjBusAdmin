package com.collegebus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.collegebus.entity.AdminEntity;
import com.collegebus.model.AdminLoginModel;
import com.collegebus.service.AdminService;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showAdmin() {
		return "homeOfStudent";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@ModelAttribute("admin") AdminLoginModel admin) {
		logger.info("Welcome adminLogin ");

		AdminEntity adminEntity = adminService.getAdminByUserName(admin.getAdminName());

		ModelAndView model = null;
		if (adminEntity != null) {
			if (admin.getAdminPassword().equals(adminEntity.getAdminPassword())) {
				logger.info("Welcome student ");

				model = new ModelAndView("homeOfStudent");
				
			} else {
				logger.info("Invalid admin ");
				model = new ModelAndView("home");
				model.addObject("result", "Invalid AdminName or AdminPassword");
				
			}
		} else {
			model = new ModelAndView("home");
			model.addObject("result", "Invalid AdminName or AdminPassword");
			
		}
		
		return model;

	}



}
