package com.service;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAllProduct(String name, Pageable pageable);

    Optional<Product> findById(int id);

    void create(Product product);

    void delete(int id);

    void update(Product product);
}
