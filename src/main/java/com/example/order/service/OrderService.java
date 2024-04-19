package com.example.order.service;

import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderModel> getListOfOrders() {
        return orderRepository.findAll();
    }
}

