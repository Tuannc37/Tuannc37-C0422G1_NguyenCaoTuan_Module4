package com.service.impl;

import com.model.Blog;
import com.repository.IBlogRepository;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll(String name) {
        return iBlogRepository.findAll(name);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void create(Blog blog) {
        iBlogRepository.create(blog);
    }

    @Override
    public void update(int id, Blog blog) {
        iBlogRepository.update(id,blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.delete(id);
    }
}
