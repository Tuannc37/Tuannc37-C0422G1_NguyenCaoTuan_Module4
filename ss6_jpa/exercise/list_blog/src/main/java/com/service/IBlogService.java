package com.service;

import com.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll(String name);

    Blog findById(int id);

    void create(Blog blog);

    void update(int id,Blog blog);

    void delete(int id);
}
