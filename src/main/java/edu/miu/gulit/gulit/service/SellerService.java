package edu.miu.gulit.gulit.service;



import edu.miu.gulit.gulit.domain.Address;
import edu.miu.gulit.gulit.domain.Order;
import edu.miu.gulit.gulitdomain.Seller;
import edu.miu.gulit.gulit.domain.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

//this is not final
public interface SellerService {
    public Seller getSellerBySId(long id);
    public Seller getSellerByName(String name);
    public List<Long> getOrderIdBySellerBySId(long sId);

    public Seller ApproveOrReject(String name, String status);
    public List<Order> getOrderBySellerById(long sId);

    public List<Seller> getAllSellers();

    public void createSeller(Seller seller);

    public void saveSeller(Seller seller);

    public Order shipSellerOrder(String name, long orderId);

    public Order cancelSellerOrder(String name, long orderId);

    public Order getOrderByIdOfSeller(String name, long orderId);
}