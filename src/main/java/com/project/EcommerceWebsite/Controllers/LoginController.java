package com.project.EcommerceWebsite.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.EcommerceWebsite.Common.APIResponse;
import com.project.EcommerceWebsite.DTO.LoginDto;
import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;
import com.project.EcommerceWebsite.Services.JWTService;


@RestController
public class LoginController {
	
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManger;
	
	@PostMapping("/sign-in")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		try {
			authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
			return jwtService.generateToken(loginDto.getEmail());
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Incorrect Email or Password");
		}

	}

}
