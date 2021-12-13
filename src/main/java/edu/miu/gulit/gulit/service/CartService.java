package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Cart;
import edu.miu.gulit.gulit.domain.Product;

public interface CartService {
    Cart findAllCart();

    Cart addToCart(long productId, int quantity);

    void deleteCartItem(int id);

    void updateCartItem(Product product, int id);
}
