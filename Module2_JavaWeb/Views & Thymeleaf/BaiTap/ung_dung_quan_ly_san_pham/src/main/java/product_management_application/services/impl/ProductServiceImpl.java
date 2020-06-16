package product_management_application.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management_application.model.Product;
import product_management_application.repository.ProductRepository;
import product_management_application.services.ProductService;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private  ProductRepository productRepository;


    @Override
    public  List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        product.setId((int)(Math.random() * 10000));
       productRepository.save(product);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findId(id) ;
    }

    @Override
    public void update (Product product) {

         productRepository.update(product.getId(),product);
    }

    @Override
    public void remove(int id) {
         productRepository.remove(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findName(name);
    }


    }

