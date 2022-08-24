package com.repository.impl;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productMap ;
    static
    {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Sách",1000, "Mới","Thiên Long"));
        productMap.put(2, new Product(2, "Vở", 2000, "Cũ","Thiên Long"));
        productMap.put(3, new Product(3, "Bút", 4000, "Mới","Thiên Long"));
        productMap.put(4, new Product(4, "Quần", 100000, "Mới","Thiên Long"));
        productMap.put(5, new Product(5, "Áo", 500000, "Cũ","Thiên Long"));

    }

    @Override
    public List<Product> findAll(String name) {
        List<Product> productList = new ArrayList<>();
        for(Product p: productMap.values()){
            if(p.getNameProduct().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))){
                productList.add(p);
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
