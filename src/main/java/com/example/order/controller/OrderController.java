package com.example.order.controller;

import com.example.order.dto.OrderDto;
import com.example.order.model.OrderModel;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getOrderList() {
        try {
            List<OrderModel> orders = orderService.getListOfOrders();
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable("id") Long id) {
        OrderModel model = orderService.getOrderById(id);
        return ResponseEntity.ok(model);
    }

    @PostMapping
    public ResponseEntity<OrderDto> postAddOrder(@RequestBody OrderDto orderDto) {
        try {
            OrderDto addedOrder = orderService.addOrder(orderDto);
            return ResponseEntity.ok(addedOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderModel> deleteOrderById(@PathVariable("id") Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
