package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Buyer;
import edu.miu.gulit.gulit.domain.OrderStatus;
import edu.miu.gulit.gulit.domain.User;
import edu.miu.gulit.gulit.domain.UserOrder;
import edu.miu.gulit.gulit.repository.UserOrderRepository;
import edu.miu.gulit.gulit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserOrderServiceImpl implements UserOrderService{

    @Autowired

    UserOrderRepository orderRepository;

    @Override
    public UserOrder findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public UserOrder loadOrderbyName(String username) {
        return null;
    }
    @Override
    public List<UserOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public UserOrder save(UserOrder data) {
        return orderRepository.save(data);
    }
    @Override
    public UserOrder update(UserOrder order, long id) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public UserOrder deliveredOrder(String userName, long id) {
        return null;
    }

//    @Override
//    public UserOrder deliveredOrder(String userName, long orderId) {
//
//        Buyer buyer =buyerRepository.getBuyerByUsername(userName);
//        List<Long> lOID= buyer.getOrders().stream().map(o->o.getId()).collect(Collectors.toList());
//        if( lOID.contains(orderId)) {
//            UserOrder order=findById(orderId);
//            order.setOrderStatus(OrderStatus.DELIVERED);
//            orderRepository.save(order);
//            buyerRepository.save(buyer);
//            return order;
//        }
//        return null;
//    }
}
