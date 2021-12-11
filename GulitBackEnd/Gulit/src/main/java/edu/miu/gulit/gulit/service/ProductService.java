package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Product update(Product product,long id);
    List<Product> getAll();
    Optional<Product> getById(long id);
    void deleteById(long id);
}
