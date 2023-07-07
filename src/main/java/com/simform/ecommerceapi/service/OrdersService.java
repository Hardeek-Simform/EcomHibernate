package com.simform.ecommerceapi.service;

import com.simform.ecommerceapi.entity.Orders;
import com.simform.ecommerceapi.entity.User;
import com.simform.ecommerceapi.repository.OrderRepo;
import com.simform.ecommerceapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    public Orders addOrder(Orders order, int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            order.setUser(user.get());
            user.get().getOrderList().add(order);
            return orderRepo.save(order);
        } else {
            throw new RuntimeException("User id is invalid");
        }
    }

    public List<Orders> getAllOrders() {
        Optional<List<Orders>> allOrders = Optional.of(orderRepo.findAll());
        if (allOrders.isPresent()) {
            return allOrders.get();
        } else {
            throw new RuntimeException("All Orders List is empty");
        }
    }

    public Orders getOrderById(int id) {
        Optional<Orders> order = orderRepo.findById(id);
        if (order.isPresent()) {
            return order.get();
        } else {
            throw new RuntimeException("order id is invalid");
        }
    }

    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);
    }

    public List<Orders> addOrder(List<Orders> order, int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            order.forEach(e -> e.setUser(user.get()));
            user.get().getOrderList().addAll(order);
            List<Orders> orders = orderRepo.saveAll(order);
            return orders;
        } else {
            throw new RuntimeException("User id is invalid");
        }

    }
}


