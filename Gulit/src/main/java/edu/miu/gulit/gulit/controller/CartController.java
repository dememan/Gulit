package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Cart;
import edu.miu.gulit.gulit.domain.CartItem;
import edu.miu.gulit.gulit.domain.OrderDetail;
import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.dto.ProductDto;
import edu.miu.gulit.gulit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<OrderDetail> getAllCartItems(){
        return cartService.getAllCartItems();
    }

    @PostMapping
    public void saveCartItem(@RequestBody ProductDto productDto){
        cartService.saveCartItem(productDto);
    }

    @PutMapping("/{id}")
    public void updateCartItem(@RequestBody ProductDto productDto, @PathVariable("id") int id){
        cartService.updateCartItem(productDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable("id") int id){
        cartService.deleteCartItem(id);
    }
}
