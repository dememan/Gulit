package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;

import java.util.List;


public interface ProductController {
    Product save(Product product);
    Product update(Product product, long id);
    List<Product> findAll();
    Product findById(long id);
    void deleteById(long id);
    List<ProductPhoto> findImagesById(long id);
}
