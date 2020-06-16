package product_management_application.repository.impl;
import org.springframework.stereotype.Repository;
import product_management_application.model.Product;
import product_management_application.repository.ProductRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer,Product> listProduct;


    static {
       listProduct = new HashMap<>();
       listProduct.put(1,new Product(1,"Iphone 7",400,"ios 9","Apple"));
        listProduct.put(2,new Product(2,"Iphone 8",500,"ios 10","Apple"));
        listProduct.put(3,new Product(3,"Iphone X",600,"ios 10","Apple"));
        listProduct.put(4,new Product(4,"Iphone 11",700,"ios 11","Apple"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void save(Product product) {
      listProduct.put(product.getId(),product);
    }

    @Override
    public Product findId(int id) {
        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
         listProduct.put(id,product);
    }

    @Override
    public void remove(int id) {
         listProduct.remove(id);
    }

    @Override
    public List<Product> findName(String name) {
        List<Product> listName = new ArrayList<>();
        for (Product list: listProduct.values() ) {
            if(list.getName().equals(name)){
                listName.add(list);
            }
        }
        return listName;
    }
}
