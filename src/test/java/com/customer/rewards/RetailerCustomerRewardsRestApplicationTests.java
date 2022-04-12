package com.customer.rewards;

import com.customer.rewards.service.RewardsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.rewards.model.Customer;

@SpringBootTest
class RetailerCustomerRewardsRestApplicationTests {
	
	@Autowired
    RewardsService rewardsService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testCalculateRewardsforMultipleTransactions() {
		Customer customer=rewardsService.calculateRewardsById(1);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==1) {
			Assertions.assertEquals(300,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforAmountBelowFifty() {
		Customer customer=rewardsService.calculateRewardsById(5);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==5) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforAmountAboveFiftyBelowHundred() {
		Customer customer=rewardsService.calculateRewardsById(3);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==3) {
			Assertions.assertEquals(5,customer.getTotalRewardAmount());
		}		
	}

	@Test
	void testCalculateRewardsforAmountAboveHundred() {
		Customer customer=rewardsService.calculateRewardsById(4);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==4) {
			Assertions.assertEquals(60,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforPastDate() {
		Customer customer=rewardsService.calculateRewardsById(6);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==6) {
			Assertions.assertEquals(0,customer.getTotalRewardAmount());
		}		
	}
	
	@Test
	void testCalculateRewardsforHundred() {
		Customer customer=rewardsService.calculateRewardsById(7);
		System.out.println("Test Customer :::: "+ customer.getName());
		if(customer.getId()==7) {
			Assertions.assertEquals(50,customer.getTotalRewardAmount());
		}		
	}

}
