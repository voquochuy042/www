package backend.services;

import backend.models.Order;
import backend.repositories.OrderRepository;

import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService() {
        orderRepository = new OrderRepository();
    }
    public Optional<Order> getOrderLatest(){
        return orderRepository.getOrderLatest();
    }
    public void insertOrder(Order order){
        orderRepository.insertOrder(order);
    }
}
