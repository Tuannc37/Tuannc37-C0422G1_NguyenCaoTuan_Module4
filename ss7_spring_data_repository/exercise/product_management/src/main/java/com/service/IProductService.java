package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(String name);

    void save(Product product);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);
}
