package product_management_application.services;
import product_management_application.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();
   void save(Product product);
   Product findProductById(int id);
   void update( Product product);
   void remove(int id );
   List<Product> findProductByName(String name);
}
