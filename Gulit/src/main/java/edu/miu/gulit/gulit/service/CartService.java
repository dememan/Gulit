package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.OrderDetail;
import edu.miu.gulit.gulit.dto.ProductDto;

import java.util.List;

public interface CartService {
    List<OrderDetail> getAllCartItems();
    void saveCartItem(ProductDto productDto);

    void deleteCartItem(int id);

    void updateCartItem(ProductDto productDto, int id);
}
