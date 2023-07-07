package com.simform.ecommerceapi.dto;

import com.simform.ecommerceapi.enums.MembershipType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MembershipDto {
    private int id;
    private MembershipType membershipType;
    private LocalDate expiry;
}
