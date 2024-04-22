package com.example.order.service;

import com.example.order.dto.OrderDto;
import com.example.order.model.OrderModel;
import com.example.order.repository.OrderRepository;
import com.example.order.utils.OrderMapper;
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

    public OrderModel getOrderById(Long id) {
    return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public OrderDto addOrder(OrderDto orderDto) {
        OrderModel orderModel = OrderMapper.toOrderModel(orderDto);
        OrderModel saved = orderRepository.save(orderModel);
        return OrderMapper.toOrderDto(saved);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

