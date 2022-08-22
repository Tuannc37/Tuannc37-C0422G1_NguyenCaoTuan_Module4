package com.service;

import com.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void update(Blog blog);

    void delete(int id);

    void save(Blog blog);

    Optional<Blog> findId(int id);
}
