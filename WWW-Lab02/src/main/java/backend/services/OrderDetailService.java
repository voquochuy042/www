package backend.services;

import backend.models.OrderDetail;
import backend.repositories.OrderDetailRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService() {
         orderDetailRepository = new OrderDetailRepository();
    }
    public void insertOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.insertOrderDetail(orderDetail);
    }
    public void updateOrderDetail(OrderDetail orderDetailNew){
        orderDetailRepository.update(orderDetailNew);
    }
//    public List<OrderDetail> getCartProducts(ArrayList<OrderDetail> orderDetails){
//        List<OrderDetail> rs = new ArrayList<>();
//        if(orderDetails.size()  > 0){
//            for(OrderDetail orderDetail : orderDetails){
//
//            }
//        }
//    }
}
