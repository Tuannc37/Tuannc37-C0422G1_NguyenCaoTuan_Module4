package com.service.impl;

import com.model.Product;
import com.repository.IProductRepository;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepository.update(id,product);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }
}
