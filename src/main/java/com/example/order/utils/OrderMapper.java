package com.example.order.utils;

import com.example.order.dto.OrderDto;
import com.example.order.model.OrderModel;

public class OrderMapper {
    public static OrderModel toOrderModel(OrderDto orderDto) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderNumber(orderDto.getOrderNumber());
        orderModel.setDeliveryTime(orderDto.getDeliveryTime());
        return orderModel;
    }

    public static OrderDto toOrderDto(OrderModel orderModel) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderNumber(orderModel.getOrderNumber());
        orderDto.setDeliveryTime(orderModel.getDeliveryTime());
        return orderDto;
    }
}
