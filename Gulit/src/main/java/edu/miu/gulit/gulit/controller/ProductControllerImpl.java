package edu.miu.gulit.gulit.controller;

import edu.miu.gulit.gulit.domain.Product;
import edu.miu.gulit.gulit.domain.ProductPhoto;
import edu.miu.gulit.gulit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<Product> findAll() {
        return service.findAll();
    }
    @Override
    @GetMapping("{id}")
    public Product findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @Override
    @PostMapping
    public Product save(@RequestBody @Valid Product data) {
        return service.save(data);
    }

    @Override
    @PutMapping("{id}")
    public Product update(@RequestBody  Product data, @PathVariable long id) {
       return service.update(data, id);
    }

    @Override
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable  long id) {
        service.deleteById(id);
    }

    @Override
    @PutMapping("/{id}/images")
    public List<ProductPhoto> findImagesById(@PathVariable long id) {
       return  service.findImagesById(id);
    }
}
