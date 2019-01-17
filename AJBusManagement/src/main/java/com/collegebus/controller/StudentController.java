package com.collegebus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.collegebus.entity.StudentEntity;
import com.collegebus.model.AdditionalDetailsModel;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.StudentLoginModel;
import com.collegebus.service.StudentService;

@Controller
@RequestMapping(value="student")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService; 

	@RequestMapping(value = "/showAdditionalDetails", method = RequestMethod.GET)
	public ModelAndView showAdditionalDetails(@RequestParam("userName") String studentMail) {
		logger.info("Welcome to the additional details page " +  studentMail);
		ModelAndView model = new ModelAndView("additionalDetails");
		model.addObject("studentMail",  studentMail);
		return model;
	}
	
	@RequestMapping(value = "/showBusTripSelection", method = RequestMethod.GET)
	public ModelAndView showBusTripSelection(@RequestParam("userName") String studentMail) {
		logger.info("Welcome to the bus trip selection page");
		ModelAndView model = new ModelAndView("busTripSelection");
		model.addObject("studentMail",  studentMail);
		return model;
	}
	
	
	@RequestMapping(value = "/showUpdate", method = RequestMethod.GET)
	public String showUpdate() {
		logger.info("Welcome to the Update Page ");
		return "update";
	}
	
	
	@RequestMapping(value = "/showPasswordChange", method = RequestMethod.GET)
	public String showPasswordChange() {
		logger.info("Welcome to the Password Change page ");
		return "passwordChange";
	}
	
	
	@RequestMapping(value = "/showPaymentSlip", method = RequestMethod.GET)
	public String showPaymentSlip() {
		logger.info("Welcome to the Payment Slip page ");
		return "challan";
	}
	
	
	@RequestMapping(value = "/showBusId", method = RequestMethod.GET)
	public String showBusId() {
		logger.info("Welcome to the bus id page! ");
		return "busId";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "homeOfStudent";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView submitStudentLogin(@ModelAttribute("student") StudentLoginModel student) {

		
		StudentEntity studentEntity = studentService.getStudentByEmail(student.getStudentEmailId());
		ModelAndView model = null;
		if (studentEntity != null) {
			if (student.getStudentPassword().equals(studentEntity.getPassword())) {
				logger.info("Welcome student ");
				model = new ModelAndView("homeOfStudent");

				model.addObject("studentMail", studentEntity.getEmailId());
			} else {
				logger.info("Invalid admin ");
				model = new ModelAndView("home");
				model.addObject("result", "Invalid Username (Email Id) or Password");
			}
		} else {

			model = new ModelAndView("home");
			model.addObject("result", "Invalid Username (Email Id) or Password");
		}

		return model;

	}

	
	@RequestMapping(value = "/login/busTripSelection", method = RequestMethod.POST)
	public ModelAndView submitbusTripSelection(@ModelAttribute("busTrip") BusTripSelectionModel busTrip) {
		
		
		studentService.saveBusTrip(busTrip);
		ModelAndView model = new ModelAndView("homeOfStudent");
		return model;

	}

	

	@RequestMapping(value = "/login/additionalDetails", method = RequestMethod.POST)
	public ModelAndView submitAdditionalDetails(@ModelAttribute("additionalDetails") AdditionalDetailsModel additionalDetailsModel) {
		
		ModelAndView model = new ModelAndView("homeOfStudent");
		return model;

	}

}
