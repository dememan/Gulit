package edu.miu.gulit.gulit.repository;

import edu.miu.gulit.gulit.domain.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CartRepository extends CrudRepository<OrderDetail, Integer> {
    @Override
    List<OrderDetail> findAll();

    @Override
    OrderDetail save(OrderDetail orderDetail);
}
