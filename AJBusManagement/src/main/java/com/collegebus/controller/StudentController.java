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

import com.collegebus.entity.BusTripEntity;
import com.collegebus.entity.StudentEntity;
import com.collegebus.model.AdditionalDetailsModel;
import com.collegebus.model.BusTripSelectionModel;
import com.collegebus.model.PasswordChangeModel;
import com.collegebus.model.StudentLoginModel;
import com.collegebus.model.UpdateModel;
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
		StudentEntity studentEntity = studentService.getStudentByEmail(studentMail);
		
		model.addObject("studentMail",  studentMail);
		model.addObject("studentEntity",  studentEntity);
		return model;
	}
	
	@RequestMapping(value = "/showBusTripSelection", method = RequestMethod.GET)
	public ModelAndView showBusTripSelection(@RequestParam("userName") String studentMail) {
		logger.info("Welcome to the bus trip selection page");		
		
		BusTripEntity busTripEntity = studentService.getBusTripByStudentEmail(studentMail);
		
		ModelAndView model = new ModelAndView("busTripSelection");
		model.addObject("studentMail",  studentMail);
		model.addObject("busTripEntity",busTripEntity);
		
		return model;
	}
	
	
	@RequestMapping(value = "/showUpdate", method = RequestMethod.GET)
	public ModelAndView showUpdateForm(@RequestParam("userName") String studentMail) {
		logger.info("Welcome to the additional details page " +  studentMail);
		ModelAndView model = new ModelAndView("update");
		StudentEntity studentEntity = studentService.getStudentByEmail(studentMail);				
		model.addObject("studentEntity",  studentEntity);
		return model;
	}
	
	
	@RequestMapping(value = "/showPasswordChange", method = RequestMethod.GET)
	public ModelAndView showPasswordChange(@RequestParam("userName") String studentMail) {
		logger.info("Welcome to the additional details page " +  studentMail);
		ModelAndView model = new ModelAndView("passwordChange");
		model.addObject("studentMail",  studentMail);
		return model;
	}
	
	
	@RequestMapping(value = "/showPaymentSlip", method = RequestMethod.GET)
	public ModelAndView showPaymentSlip(@RequestParam("userName") String userName) {				
		logger.info("Welcome to the Payment Slip page");
		ModelAndView model =  new ModelAndView("challan");
		StudentEntity student = studentService.getStudentByEmail(userName);
		model.addObject("studentEntity", student);
		return model;
		
	}
	
	
	@RequestMapping(value = "/showBusId", method = RequestMethod.GET)
	public ModelAndView  showBusId(@RequestParam("userName") String userName) {
		logger.info("Welcome to the bus id page! ");
		
		ModelAndView model =  new ModelAndView("busId");
		StudentEntity student = studentService.getStudentByEmail(userName);
		model.addObject("studentEntity", student);
		return model;		
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

	
	@RequestMapping(value = "/submitAdditionalDetails", method = RequestMethod.POST)
	public ModelAndView submitAdditionalDetails(@ModelAttribute("additionalDetails") AdditionalDetailsModel additionalDetailsModel) {
		
		studentService.saveAdditionalDetails(additionalDetailsModel);
		ModelAndView model = new ModelAndView("homeOfStudent");
		model.addObject("result", "Your Additional Details was successfully saved");
		model.addObject("alertHeader", "success");		
		return model;

	}

	
	@RequestMapping(value = "/submitBusTripSelection", method = RequestMethod.POST)
	public ModelAndView submitbusTripSelection(@ModelAttribute("busTrip") BusTripSelectionModel busTrip) {		
		
		studentService.saveBusTrip(busTrip);
		ModelAndView model = new ModelAndView("homeOfStudent");
		model.addObject("result", "Your Bus Trip Selection was successfully saved");
		model.addObject("alertHeader", "success");
		return model;

	}

	
	@RequestMapping(value = "/submitPasswordChange", method = RequestMethod.POST)
	public ModelAndView submitPasswordChange(@ModelAttribute("passwordChange") PasswordChangeModel passwordChangeModel ) {
		
		ModelAndView model = new ModelAndView("homeOfStudent");
		
		StudentEntity studentEntity = studentService.getStudentByEmail(passwordChangeModel.getStudentMail());
		
		if(studentEntity.getPassword().equals(passwordChangeModel.getOld())){
				studentService.changePassword(passwordChangeModel);
				model.addObject("result", "Your Old Password was successfully Changed as New Password");
				model.addObject("alertHeader", "success");
		} else {
			model.addObject("result", "Your Old Password was incorrect");
		}
		return model;

	}

	
	@RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
	public ModelAndView submitUpdate(@ModelAttribute("passwordChange") UpdateModel updateModel ) {			
		
		studentService.update(updateModel);
		
		StudentEntity studentEntity = studentService.getStudentByEmail(updateModel.getEmailId());
		
		ModelAndView model = new ModelAndView("homeOfStudent");
		model.addObject("studentEntity", studentEntity);
		
		return model;

	}

	

	
}
