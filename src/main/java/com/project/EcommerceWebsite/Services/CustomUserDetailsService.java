package com.project.EcommerceWebsite.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.EcommerceWebsite.Entities.Customer;
import com.project.EcommerceWebsite.Repository.CustomerRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer=customerRepo.findByEmail(email);
		if(customer==null) {
			System.out.println(email+"Email doesn't exits");
			throw new UsernameNotFoundException(email+"Email doesn't exits");
		}
		return new CustomCustomerDetails(customer);
	}

}
