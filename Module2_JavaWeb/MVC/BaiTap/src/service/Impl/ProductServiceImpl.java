package service.Impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> listProduct ;
    static {
        listProduct = new HashMap<>();
        listProduct.put(1,new Product(1,"iphone x","Apple",700,"https://cdn.tgdd.vn/Products/Images/42/114115/iphone-x-64gb-2-400x460.png"));
        listProduct.put(2,new Product(2,"SumSung note 10","SamSung",990,"https://cdn.tgdd.vn/Products/Images/42/191276/samsung-galaxy-note-10-silver-400x460.png"));
        listProduct.put(3,new Product(3,"Vsmart Joy 3","Vsmart",170,"https://cdn.tgdd.vn/Products/Images/42/219208/vsmart-joy-3-4gb-den-400x460-400x460.png"));
        listProduct.put(4,new Product(4,"Xiaomi Redmi Note 8 x","Xiaomi",220,"https://cdn.tgdd.vn/Products/Images/42/212374/xiaomi-redmi-note-8-128gb-black-400x460.png"));
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
    public Product findById(int id) {

        return listProduct.get(id);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id,product);
    }

    @Override
    public void remote(int id) {
      listProduct.remove(id);
    }

}
