package com.RewardManagementAPI.RewardManagementAPI.controller;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.Customer;
import com.RewardManagementAPI.RewardManagementAPI.exception.CustomerCannotBeFoundException;
import com.RewardManagementAPI.RewardManagementAPI.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/rewards")
public class CustomerController {


    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.OK);
    }



    @GetMapping("{customerId}/balance")
    public ResponseEntity<?> getRewardsBalance(@PathVariable Long customerId) {
        try {
            Optional<Customer> foundCustomerRewardBalance = customerService.getRewardBalance(customerId);
            return new ResponseEntity<>(foundCustomerRewardBalance, HttpStatus.OK);
        } catch (CustomerCannotBeFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("{customerId}/history")
    public ResponseEntity<?> getCashbackHistory(@PathVariable Long customerId) {
        try {
            return new ResponseEntity<>(customerService.getCashBackHistory(customerId), HttpStatus.ACCEPTED);
        } catch (CustomerCannotBeFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
