package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order updatePartial(Order order) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
