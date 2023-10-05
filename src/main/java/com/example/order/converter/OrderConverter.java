package com.example.order.converter;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.Customer;
import com.example.order.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConverter implements Converter<Order, OrderDTO>{

    @Override
    public OrderDTO fromEntity(Order entity) {
        return OrderDTO.builder()
                .id(entity.getId())
                .codOrder(entity.getCodOrder())
                .state(entity.getStateOrder())
                .customerId(entity.getCustomer().getId())
                .build();
    }

    @Override
    public Order fromDTO(OrderDTO dto) {
        return Order.builder()
                .codOrder(dto.getCodOrder())
                .stateOrder("CREATED")
                .customer(Customer.builder()
                        .id(dto.getCustomerId())
                        .build())
                .build();
    }

    @Override
    public List<OrderDTO> fromEntity(List<Order> entities) {
        return entities.stream().map(entity -> OrderDTO.builder()
                        .id(entity.getId())
                        .codOrder(entity.getCodOrder())
                        .state(entity.getStateOrder())
                        .customerId(entity.getCustomer().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> fromDTO(List<OrderDTO> dtoList) {
        return Converter.super.fromDTO(dtoList);
    }
}
