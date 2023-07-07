package com.simform.ecommerceapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private int age;
    private MembershipDto membership;
    private List<OrdersDto> orderList;
}
