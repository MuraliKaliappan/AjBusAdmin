package com.collegebus.controller;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.collegebus.entity.AdminEntity;
import com.collegebus.entity.BusTripEntity;
import com.collegebus.model.AdminLoginModel;
import com.collegebus.model.AdminRouteCostModel;
import com.collegebus.model.PasswordChangeModel;
import com.collegebus.service.AdminService;


@Controller
@RequestMapping("admin")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showAdmin() {
		return "homeOfAdmin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView adminLogin(@ModelAttribute("admin") AdminLoginModel admin) {
		logger.info("Welcome adminLogin ");

		AdminEntity adminEntity = adminService.getAdminByUserName(admin.getAdminName());

		ModelAndView model = null;
		if (adminEntity != null) {
			if (admin.getAdminPassword().equals(adminEntity.getAdminPassword())) {
				logger.info("Welcome student ");
				//List<BusTripEntity> busTripEntities = adminService.getPendingBusTrip();
				model = new ModelAndView("homeOfAdmin");
				//model.addObject("busTrips", busTripEntities);		
				model.addObject("adminName", adminEntity.getAdminName());
			} else {
				logger.info("Invalid admin ");
				model = new ModelAndView("home");
				model.addObject("result", "Invalid AdminName or AdminPassword");
				model.addObject("alertHeader", "Error");
			}
		} else {
			model = new ModelAndView("home");
			model.addObject("result", "Invalid AdminName or AdminPassword");
			model.addObject("alertHeader", "Error");
		}
		
		return model;

	}
	
	@RequestMapping(value = "/showPasswordChange", method = RequestMethod.GET)
	public ModelAndView showPasswordChange(@RequestParam("userName") String userName) {
		logger.info("Welcome to the additional details page " +  userName);
		ModelAndView model = new ModelAndView("passwordChange");
		model.addObject("userName",  userName);
		return model;
	}
		
	@RequestMapping(value = "/showTripManagement", method = RequestMethod.GET)
	public ModelAndView showTripManagement() {
		ModelAndView model = null;
		
		if(adminService.getAllRouteCost().size() == 3) {
			
			List<BusTripEntity> busTripEntities = adminService.getPendingBusTrip();
			model = new ModelAndView("tripManagement");
			model.addObject("busTrips", busTripEntities);
			
		} else {
			
			model = new ModelAndView("homeOfAdmin");
			model.addObject("result", "Please select the Route Cost Details At Very First");
			model.addObject("alertHeader", "Warning");
		}
		return model;
	}
	
	
	@RequestMapping(value = "/showPaymentDetails", method = RequestMethod.GET)
	public ModelAndView showPaymentDetails() {
				
			List<BusTripEntity> busTripEntities = adminService.getFinalStatusOfBusTrip();
			ModelAndView model = new ModelAndView("paymentDetails");
			model.addObject("busTrips", busTripEntities);
			return model;
	}

	
	@RequestMapping(value="savePaymentDetails",method = RequestMethod.GET)
	public ModelAndView updatePaymentDetails(@RequestParam("busId") Integer busSerialNo, @RequestParam("status") Boolean status ){
		
		adminService.updateFeeStatus(busSerialNo, status);
		List<BusTripEntity> busTripEntities = adminService.getFinalStatusOfBusTrip();
		ModelAndView model = new ModelAndView("homeOfAdmin");
		model.addObject("busTrips", busTripEntities);
		model.addObject("result", "Student's payment details was successfully stored");
		model.addObject("alertHeader", "Message");
		return model;
		
	}
	
	
	@RequestMapping(value="saveTripDetails",method = RequestMethod.GET)
	public ModelAndView getTripDetails(@RequestParam("busId") Integer busSerialNo, @RequestParam("status") Boolean status ){
		ModelAndView model = new ModelAndView("homeOfAdmin");
		
		BusTripEntity busTripEntity = adminService.getBusTripBySerialNo(busSerialNo);
		
		List list= adminService.checkAvailabilityOfBusSeats(busTripEntity.getArea(),busTripEntity.getTrip());
	
		Integer count = list.size();
		System.out.print(count);
		if(count <= 3) {
			
			adminService.updateBusStatus(busSerialNo, status);
			model.addObject("result", "Your  Acceptance / Rejection of Bus trip was successfully sent to the particular student ");
			model.addObject("alertHeader", "success");
		} else {
			
			model.addObject("result", "The seats of that trip was already booked");
			model.addObject("alertHeader", "Warning !");
		}
		
		
		List<BusTripEntity> busTripEntities = adminService.getPendingBusTrip();
		
		model.addObject("busTrips", busTripEntities);
		
		return model;
		
	}
	
	
	
	@RequestMapping(value = "/showRouteCost", method = RequestMethod.GET)
	public ModelAndView showRouteCost() {
		ModelAndView model = new ModelAndView("routeCost");	
		model.addObject("routeCosts", adminService.getAllRouteCost());
		return model;
	}
	
	@RequestMapping(value = "/saveRouteCost", method = RequestMethod.POST)
	public ModelAndView saveRouteCost(@ModelAttribute("routeCost") AdminRouteCostModel adminRouteCostModel) {
		
		adminService.saveRouteCost(adminRouteCostModel);
		ModelAndView model = new ModelAndView("homeOfAdmin");
		model.addObject("result", "Your Route cost was successfully saved or updated");
		model.addObject("alertHeader", "success");
		
		return model;
	}
	
	@RequestMapping(value = "/submitPasswordChange", method = RequestMethod.POST)
	public ModelAndView submitPasswordChange(@ModelAttribute("passwordChange") PasswordChangeModel passwordChangeModel ) {
		
		ModelAndView model = new ModelAndView("homeOfAdmin");
		
		AdminEntity adminEntity = adminService.getAdminByUserName(passwordChangeModel.getUserName());

		
		if(adminEntity.getAdminPassword().equals(passwordChangeModel.getOld())){
				adminService.changePassword(passwordChangeModel);
				model.addObject("result", "Your Old Password was successfully Changed as New Password");
				model.addObject("alertHeader", "success");
		} else {
			model.addObject("result", "Your Old Password was incorrect");
			model.addObject("alertHeader", "Error!");
		}
		return model;

	}



}
