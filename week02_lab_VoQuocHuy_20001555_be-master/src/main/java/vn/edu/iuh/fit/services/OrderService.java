package vn.edu.iuh.fit.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {
    @Inject
    OrderRepository orderRepository;

    public boolean add(Order o){
        return orderRepository.add(o);
    }
    public List<Order> getAll(int page) {
        return orderRepository.getAll(page);
    }
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }
    public Optional<Boolean> update(Order order) {
        Optional<Order> orderFind = findById(order.getId());

        if (orderFind.isEmpty())
            return Optional.empty();

        return Optional.of(orderRepository.update(order));
    }
}
