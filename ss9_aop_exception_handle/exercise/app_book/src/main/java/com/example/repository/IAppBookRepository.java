package com.example.repository;

import com.example.model.AppBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAppBookRepository extends JpaRepository<AppBook,Integer> {
    Page<AppBook> findByNameStoryContaining(String name, Pageable pageable);
}
