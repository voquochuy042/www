package backend.test;

import backend.models.*;
import backend.services.OrderDetailService;
import backend.services.OrderService;
import backend.services.ProductImageService;
import backend.services.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestMapping {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 200; i++) {
            // Ensure unique order IDs
            long orderId = (long) Math.floor(Math.random() * (123 - 74 + 1) + 74);

            long productId = (long) random.nextInt(10) + 1;
            double quantity = Math.floor(Math.random() * (20 - 5 + 1) + 5);

            // Use BigDecimal for precision in prices
            BigDecimal price = BigDecimal.valueOf(Math.floor(Math.random() * (500000 - 10000 + 1) + 10000));

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(new Product(productId));
            orderDetail.setQuantity(quantity);
            orderDetail.setNote("Order Complete");
            orderDetail.setOrder(new Order(orderId));
            orderDetail.setPrice(20000);
            orderDetailService.insertOrderDetail(orderDetail);
        }
    }
}
