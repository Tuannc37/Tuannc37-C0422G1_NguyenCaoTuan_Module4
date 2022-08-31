package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory(Integer id) {
        return iBlogRepository.findAllByCategory_Id(id);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog save(Blog blog) {
      return iBlogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findId(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAllByNameBlog(String name, Pageable pageable) {
        return iBlogRepository.findByNameBlogContaining(name,pageable);
    }
}
