package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllByCategory(Integer id);

    void delete(int id);

    Blog save(Blog blog);

    Optional<Blog> findId(int id);

    Page<Blog> findAllByNameBlog(String name, Pageable pageable);
}
