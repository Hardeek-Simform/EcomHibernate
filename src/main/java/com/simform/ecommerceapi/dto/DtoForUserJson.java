package com.simform.ecommerceapi.dto;

import com.simform.ecommerceapi.entity.Orders;
import com.simform.ecommerceapi.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class DtoForUserJson {
    private User user;
    private List<Orders> ordersList;

}
