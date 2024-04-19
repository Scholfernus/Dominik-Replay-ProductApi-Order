package com.example.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {
    private String orderNumber;
    private LocalDateTime deliveryTime;
}
