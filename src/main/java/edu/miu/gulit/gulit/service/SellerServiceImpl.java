package edu.miu.gulit.gulit.service;

    import edu.miu.gulit.gulit.domain.Product;
        import edu.miu.gulit.gulit.domain.Seller;
        import edu.miu.gulit.gulit.repository.SellerRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
@Service
class SellerServiceImpl implements  SellerService {
    @Autowired
    SellerRepository SellerRepository;

    @Override
    public Optional<Seller> loadSellerByName(String name) {
        // return SellerRepository.findById(id);
        return SellerRepository.findByUsername(name);
    }
    @Override
    public void approveSeller(long id) {
        if (SellerRepository.findById(id).get().isApproved()==false)
            SellerRepository.findById(id).get().setApproved(true);
        else
            System.out.println("Seller is already approved");
    }

    @Override
    public Seller save(Seller seller) {
        if(loadSellerByName(seller.getUser().getUsername())!=null) {
            System.out.println("Seller is already registered");
            return null;
        }
        return SellerRepository.save(seller);
    }
    @Override
    public Seller update(Seller seller, long id) {
        seller.setSellerId(id);
        return SellerRepository.save(seller);
    }
    @Override
    public List<Seller> findAll() {
        return SellerRepository.findAll();
    }
    @Override
    public Optional<Seller> findById(long id) {

        return SellerRepository.findById(id);
    }
    @Override
    public void deleteById(long id) {
        if(findById(id)!=null)
        {
            SellerRepository.deleteById(id);
        }
        else
        {
            System.out.println("seller doesn't exist");
        }
    }

    @Override
    public List<Product> findProductsBySellerId(long id) {
        List<Product>  result =null;
       Optional<Seller> sellingPersong = findById(id);
                for(Product p : sellingPersong.get().getProducts())
                result.add(p) ;
        return result;
    }}