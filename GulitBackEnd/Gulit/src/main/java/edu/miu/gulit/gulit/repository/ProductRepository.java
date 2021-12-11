package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    @Override
    public Product save(Product entity) ;

    @Override
    public Optional<Product> findById(Long aLong);

    @Override
    public boolean existsById(Long aLong);

    @Override
    public List<Product> findAll() ;

    @Override
    public void deleteById(Long aLong);
}
