package edu.miu.gulit.gulit.controller.domain;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CartItemDto {

    private int id;
    private ProductDto product;
    private int quantity;
}
