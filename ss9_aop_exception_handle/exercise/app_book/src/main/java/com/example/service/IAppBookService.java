package com.example.service;

import com.example.model.AppBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAppBookService {
    Page<AppBook> findAllAppBook(String name, Pageable pageable);

    void update(AppBook appBook);

    AppBook findById(int id);
}
