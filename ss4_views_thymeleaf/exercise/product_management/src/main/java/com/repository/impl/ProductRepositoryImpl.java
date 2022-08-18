package com.repository.impl;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
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
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product:productMap.values()) {
            if (product.getNameProduct().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
