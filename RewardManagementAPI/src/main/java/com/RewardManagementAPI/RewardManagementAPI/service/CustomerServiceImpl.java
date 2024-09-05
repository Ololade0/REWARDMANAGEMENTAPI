package com.RewardManagementAPI.RewardManagementAPI.service;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.CashBackHistory;
import com.RewardManagementAPI.RewardManagementAPI.dao.model.Customer;
import com.RewardManagementAPI.RewardManagementAPI.dao.repository.CustomerRepository;

import com.RewardManagementAPI.RewardManagementAPI.exception.CustomerCannotBeFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CashBackHistoryService cashBackHistoryService;

    public Customer registerCustomer(Customer customer)  {
        customer.setTotalCashBack(customer.getTotalCashBack());
         customer.setCurrentBalance(customer.getCurrentBalance());
         return customerRepository.save(customer);
    }


    public Optional<Customer> getRewardBalance(Long customerId) {
    Optional<Customer> foundCustomer = customerRepository.findByCustomerId(customerId);
    if (foundCustomer.isEmpty()) {
        throw new CustomerCannotBeFoundException(("Customer with ID " + customerId + " not found"));
    }

    return foundCustomer;
}

    public List<CashBackHistory> getCashBackHistory(Long customerId) {
        List<CashBackHistory>  foundCashBackHistories = cashBackHistoryService.getCashBackTransactionHistoryByCustomerId(customerId);
        if (foundCashBackHistories.isEmpty()) {
            throw new CustomerCannotBeFoundException(("Customer with ID " + customerId + " not found"));
        }
        return foundCashBackHistories;
    }
}
