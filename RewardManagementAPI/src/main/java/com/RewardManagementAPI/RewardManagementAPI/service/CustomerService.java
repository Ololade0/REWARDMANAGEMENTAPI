package com.RewardManagementAPI.RewardManagementAPI.service;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.Customer;

import java.util.Optional;

public interface CustomerService {
public Customer registerCustomer(Customer customer);
public Optional<Customer> getRewardBalance(Long customerId);
}
