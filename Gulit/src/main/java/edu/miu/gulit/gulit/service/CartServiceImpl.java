package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.CartItem;
import edu.miu.gulit.gulit.domain.OrderDetail;
import edu.miu.gulit.gulit.dto.ProductDto;
import edu.miu.gulit.gulit.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    CartItem cartItem;

    @Override
    public List<OrderDetail> getAllCartItems() {
        return cartRepository.findAll();
    }

    public void saveCartItem(ProductDto productDto) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setName(productDto.getName());
        orderDetail.setDescription(productDto.getDescription());
        orderDetail.setIsActive(productDto.getIsActive());
        orderDetail.setQuantity(productDto.getQuantity());
        orderDetail.setPrice(productDto.getPrice());
        orderDetail.setOrderItems(productDto.getOrderItems());
        orderDetail.setCategory(productDto.getCategory());
        orderDetail.setBrand(productDto.getBrand());
        orderDetail.setImages(productDto.getImages());

        cartRepository.save(orderDetail);
    }

    @Override
    public void deleteCartItem(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void updateCartItem(ProductDto productDto, int id) {
        OrderDetail orderDetailUpdate = new OrderDetail();
        orderDetailUpdate.setId(id);
        orderDetailUpdate.setName(productDto.getName());
        orderDetailUpdate.setDescription(productDto.getDescription());
        orderDetailUpdate.setIsActive(productDto.getIsActive());
        orderDetailUpdate.setQuantity(productDto.getQuantity());
        orderDetailUpdate.setPrice(productDto.getPrice());
        orderDetailUpdate.setOrderItems(productDto.getOrderItems());
        orderDetailUpdate.setCategory(productDto.getCategory());
        orderDetailUpdate.setBrand(productDto.getBrand());
        orderDetailUpdate.setImages(productDto.getImages());

        cartRepository.save(orderDetailUpdate);
    }
}
