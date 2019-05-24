package com.ani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


	@Controller
	public class AboutusController {
		public AboutusController() {
			
		}
		@RequestMapping("/aboutus")
		public String goToAboutUs()
		{
			return "aboutus";
		}


		@Controller
		public class UserAboutusController {
			public UserAboutusController() {
				
			}
			@RequestMapping("/useraboutus")
			public String goToUserAboutUs()
			{
				return "useraboutus";
			}
		}
	}