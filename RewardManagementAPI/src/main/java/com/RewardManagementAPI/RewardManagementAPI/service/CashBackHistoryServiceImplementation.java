package com.RewardManagementAPI.RewardManagementAPI.service;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.CashBackHistory;
import com.RewardManagementAPI.RewardManagementAPI.dao.repository.CashBackHistoryRepository;
import com.RewardManagementAPI.RewardManagementAPI.exception.CustomerCannotBeFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
public class CashBackHistoryServiceImplementation implements CashBackHistoryService {

    @Autowired
    private CashBackHistoryRepository cashBackHistoryRepository;

    public CashBackHistory createCashbackTransaction(CashBackHistory cashBackHistory) {
        cashBackHistory.setTransactionId(cashBackHistory.getTransactionId());
        cashBackHistory.setCustomerId(cashBackHistory.getCustomerId());
        cashBackHistory.setAmountEarned(cashBackHistory.getAmountEarned());
        cashBackHistory.setTransactionDate(LocalDate.now());
        cashBackHistory.setDescription(cashBackHistory.getDescription());
         return cashBackHistoryRepository.save(cashBackHistory);
    }
//    private Long generateTransactionId() {
//        return System.currentTimeMillis();
//    }

    @Override
    public List<CashBackHistory> getCashBackTransactionHistoryByCustomerId(Long customerId) {
        if(cashBackHistoryRepository.findByCustomerId(customerId) != null){
            return cashBackHistoryRepository.findByCustomerId(customerId);
        }
        throw new CustomerCannotBeFoundException("Customer with id " + customerId + " not found");
    }
}



