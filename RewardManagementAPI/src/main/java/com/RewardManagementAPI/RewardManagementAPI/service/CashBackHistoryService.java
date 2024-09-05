package com.RewardManagementAPI.RewardManagementAPI.service;
import com.RewardManagementAPI.RewardManagementAPI.dao.model.CashBackHistory;
import java.util.List;


public interface CashBackHistoryService  {
    CashBackHistory createCashbackTransaction(CashBackHistory cashBackHistory);
    List<CashBackHistory> getCashBackTransactionHistoryByCustomerId(Long customerId);
}
