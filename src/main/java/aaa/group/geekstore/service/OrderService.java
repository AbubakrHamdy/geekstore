package aaa.group.geekstore.service;

import aaa.group.geekstore.model.Order;
import aaa.group.geekstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(UUID id) {
        return orderRepository.findById(id);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order update(UUID id, Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteById(UUID id) {
        orderRepository.deleteById(id);
    }
}
