package edu.miu.gulit.gulit.service;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        if(repository.existsById(product.getId())) {
            System.out.println("Product already registered");
            return null;
        }
       return repository.save(product);
    }

    @Override
    public Product update(Product product, long id) {
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }



    @Override
    public Optional<Product> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }
}
