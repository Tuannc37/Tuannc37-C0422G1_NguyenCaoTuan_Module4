package com.example.service.impl;

import com.example.model.AppBook;
import com.example.repository.IAppBookRepository;
import com.example.service.IAppBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AppBoookService implements IAppBookService {

    @Autowired
    private IAppBookRepository iAppBookRepository;

    @Override
    public Page<AppBook> findAllAppBook(String name, Pageable pageable) {
        return iAppBookRepository.findByNameStoryContaining(name,pageable);
    }

    @Override
    public void update(AppBook appBook) {
        iAppBookRepository.save(appBook);
    }

    @Override
    public AppBook findById(int id) {
        return iAppBookRepository.findById(id).orElse(null);
    }
}
