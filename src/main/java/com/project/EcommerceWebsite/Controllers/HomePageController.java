package com.project.EcommerceWebsite.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController {
	
	@GetMapping("/")
	public String homepage() {
		return "This is home page";
	}

}
