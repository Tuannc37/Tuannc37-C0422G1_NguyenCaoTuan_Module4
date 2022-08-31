package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameBlogContaining(String name, Pageable pageable);
    List<Blog> findAllByCategory_Id(Integer id);
}
