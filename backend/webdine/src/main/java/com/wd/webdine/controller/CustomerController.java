package com.wd.webdine.controller;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wd.webdine.entity.Customer;
import com.wd.webdine.exception.UserNotExistException;
import com.wd.webdine.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	  private final CustomerServiceImpl customerService;


	  @Autowired
	  public CustomerController(CustomerServiceImpl customerService) {
	    this.customerService = customerService;
	  }

	  @GetMapping("/path")
	  public Customer getCustomerById(@PathVariable("id") String id)
	      throws UserNotExistException {
		  System.out.println("I am inside path");
	    return customerService.getUser(id)
	        .orElseThrow(() -> new UserNotExistException("User doesn't exist"));
	  }

	@GetMapping("/test")
	public void getAPI() {
		System.out.println("some random");
	}

	@PostMapping(path = "/register")
	  public Customer registerCustomer(@RequestBody String jsonUser)
		    {

		    JSONObject user = new JSONObject(jsonUser);
		    String userName = user.getString("userName");
//		    String password = user.getString("password");
		    String phoneNumber = user.getString("phoneNumber");
		    String address = user.getString("address");
		    String city = user.getString("city");
		    String state = user.getString("state");
		    String zip = "123";
		    Customer customer = customerService.addUser(userName, phoneNumber, address, city, state, zip);
		    return customer;
		  }

}
