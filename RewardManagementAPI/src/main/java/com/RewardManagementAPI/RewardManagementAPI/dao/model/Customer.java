package com.RewardManagementAPI.RewardManagementAPI.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Customers_Reward")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long customerId;
    private BigDecimal totalCashBack;
    private BigDecimal currentBalance;

}

