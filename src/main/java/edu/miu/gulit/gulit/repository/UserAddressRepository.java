package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.UserAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAddressRepository extends CrudRepository<UserAddress, Integer> {
    @Override
    List<UserAddress> findAll();
}
