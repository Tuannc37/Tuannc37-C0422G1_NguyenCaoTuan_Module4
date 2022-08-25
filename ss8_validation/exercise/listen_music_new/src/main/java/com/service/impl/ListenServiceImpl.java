package com.service.impl;

import com.model.Listen;
import com.repository.IListenRepository;
import com.service.IListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListenServiceImpl implements IListenService {
    @Autowired
    private IListenRepository iListenRepository;

    @Override
    public List<Listen> findAll() {
        return iListenRepository.findAll();
    }

    @Override
    public void create(Listen listen) {
        iListenRepository.save(listen);
    }

    @Override
    public void update(Listen listen) {
        iListenRepository.save(listen);
    }

    @Override
    public Optional<Listen> findId(int id) {
        return iListenRepository.findById(id);
    }
}
