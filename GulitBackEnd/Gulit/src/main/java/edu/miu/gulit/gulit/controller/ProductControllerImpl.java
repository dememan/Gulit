package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController {

    ProductService service;

    @Autowired
    public ProductControllerImpl(ProductService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping({"id"})
    public Optional<Product> getById(@PathVariable long id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public Product save(@RequestBody  Product data) {
        return service.save(data);
    }

    @Override
    @PutMapping({"id"})
    public Product update(@RequestBody  Product data, @PathVariable long id) {
       return service.update(data, id);
    }

    @Override
    @DeleteMapping
    public void deleteById(@PathVariable  long id) {
        service.deleteById(id);
    }
}
