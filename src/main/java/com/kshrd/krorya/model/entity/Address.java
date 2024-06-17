package com.kshrd.krorya.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private UUID addressId;
    private String buyerName;
    private String phoneNumber;
    private String buyerLatitude;
    private String buyerLongitude;

}
