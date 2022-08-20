package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String name);

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);

}
