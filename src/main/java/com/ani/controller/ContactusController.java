package com.ani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


	@Controller
	public class ContactusController {
		public ContactusController() {
			
		}
		@RequestMapping("/contactus")
		public String goToAboutUs()
		{
			return "contactus";
		}
		@Controller
		public class UserContactusController {
			public UserContactusController() {
				
			}
			@RequestMapping("/usercontactus")
			public String goToAboutUs()
			{
				return "usercontactus";
			}
		}


	}
	
