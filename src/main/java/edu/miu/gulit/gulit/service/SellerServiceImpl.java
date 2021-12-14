package edu.miu.gulit.gulit.service;

    import edu.miu.gulit.gulit.domain.Product;
        import edu.miu.gulit.gulit.domain.Seller;
        import edu.miu.gulit.gulit.repository.SellerRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

    import javax.swing.text.html.Option;
    import java.util.List;
        import java.util.Optional;
@Service
class SellerServiceImpl implements  SellerService {
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Optional<Seller> loadSellerByName(String name) {
        // return SellerRepository.findById(id);
        return sellerRepository.findByUsername(name);
    }
    @Override
    public void approveSeller(long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (seller.get().isApproved() ==false) {
            seller.get().setApproved(true);
            sellerRepository.save(seller.get());
        }
        else
            System.out.println("Seller is already approved");
    }

    @Override
    public Seller save(Seller seller) {
        if(loadSellerByName(seller.getUser().getUsername()).orElse(null)!=null) {
            System.out.println("Seller is already registered");
            return null;
        }
        return sellerRepository.save(seller);
    }
    @Override
    public Seller update(Seller seller, long id) {
        seller.setSellerId(id);
        return sellerRepository.save(seller);
    }
    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }
    @Override
    public Optional<Seller> findById(long id) {

        return sellerRepository.findById(id);
    }
    @Override
    public void deleteById(long id) {
        if(findById(id)!=null)
        {
            sellerRepository.deleteById(id);
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