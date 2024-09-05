package com.RewardManagementAPI.RewardManagementAPI.dao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CashBackHistory")
public class CashBackHistory {
    @Id
    private Long transactionId;
    private Long customerId;
    private LocalDate transactionDate;
    private BigDecimal amountEarned;
    private String description;

}
