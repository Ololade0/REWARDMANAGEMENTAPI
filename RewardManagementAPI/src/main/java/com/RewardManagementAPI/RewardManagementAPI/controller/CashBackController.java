package com.RewardManagementAPI.RewardManagementAPI.controller;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.CashBackHistory;
import com.RewardManagementAPI.RewardManagementAPI.service.CashBackHistoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rewards/cash")
public class CashBackController {
    @Autowired
   private CashBackHistoryServiceImplementation cashBackHistoryServiceImplementation;

@PostMapping("/createTransaction")
    public ResponseEntity<?> createCashBackTransaction(@RequestBody  CashBackHistory cashBackHistory) {
       CashBackHistory savedCashBackHistory =  cashBackHistoryServiceImplementation.createCashbackTransaction(cashBackHistory);
        return new ResponseEntity<>(savedCashBackHistory, HttpStatus.CREATED);
    }

}
