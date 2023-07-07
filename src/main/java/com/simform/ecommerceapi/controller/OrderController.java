package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.entity.Orders;
import com.simform.ecommerceapi.service.OrdersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> allOrders = ordersService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable int id) {
        Orders orderById = ordersService.getOrderById(id);
        return new ResponseEntity<>(orderById, HttpStatus.FOUND);
    }

    @Transactional
    @PostMapping("/{id}")
    public ResponseEntity<List<Orders>> addOrderList(@RequestBody List<Orders> orders, @PathVariable int id) {
        /* response needed in array format in json [{}]
        id in url = userId
        for add operation = productName
        */
        List<Orders> addedOrders = ordersService.addOrder(orders, id);
        return new ResponseEntity<>(addedOrders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable int id) {
        ordersService.deleteOrderById(id);
        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }

}
