package com.customer.rewards.controller;

import java.util.List;

import com.customer.rewards.exception.CustomerNotFoundException;
import com.customer.rewards.service.RewardsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.model.Customer;

@RestController
@RequestMapping("/rewards")
public class RewardsController {
	Logger logger = LoggerFactory.getLogger(RewardsController.class);
	
	@Autowired
	private RewardsService rewardsService;
	
	@GetMapping
    public ResponseEntity<Object> getCustomerRewards() {
		logger.info("In RewardsController::getCustomerRewards method start");
		List<Customer> customerList = rewardsService.calculateRewardsForAll();
		
		if (customerList.isEmpty() || customerList.size() == 0) {
			logger.error("In RewardsController::getCustomerRewards Customer List is empty");
			throw new CustomerNotFoundException("Customers not available");
		}
		
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@GetMapping(value="/{customerId}")
    public ResponseEntity<Customer> getCustomerRewardById(@PathVariable Integer customerId) {
		logger.info("In RewardsController::getCustomerRewardById method start");
		Customer customerRewardsSummary = rewardsService.calculateRewardsById(customerId);
		
		if (customerRewardsSummary == null) {
			logger.error("In RewardsController::getCustomerRewardById Customer Object is Empty or No Customer Record Found");
			throw new CustomerNotFoundException("Customer with Id::::" + customerId + " does not exist");
		}
		
		return new ResponseEntity<Customer>(customerRewardsSummary, HttpStatus.OK);
	}
	
}
