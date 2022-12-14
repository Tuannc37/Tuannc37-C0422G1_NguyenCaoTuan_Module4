package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    void update(Blog blog);

    void delete(int id);

    void save(Blog blog);

    Optional<Blog> findId(int id);

    Page<Blog> findAllByNameBlog(String name, Pageable pageable);
}
