package com.kshrd.krorya.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private UUID orderId;
    private UUID buyerId;
    private String orderDescription;
    private BigDecimal orderTotalAmount;
    private Date createdAt;
    private Date updatedAt;
}
