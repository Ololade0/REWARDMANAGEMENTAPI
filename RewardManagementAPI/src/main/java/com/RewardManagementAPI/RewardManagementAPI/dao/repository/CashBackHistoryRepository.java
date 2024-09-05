package com.RewardManagementAPI.RewardManagementAPI.dao.repository;

import com.RewardManagementAPI.RewardManagementAPI.dao.model.CashBackHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashBackHistoryRepository extends JpaRepository<CashBackHistory, Long> {
    List<CashBackHistory> findCashBackHistoriesByCustomerId(Long customerId);
    List<CashBackHistory> findByCustomerId(Long customerId);
}
