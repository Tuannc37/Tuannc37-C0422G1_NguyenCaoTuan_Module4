package com.service.impl;

import com.model.Listen;
import com.repository.IListenRepository;
import com.service.IListenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenServiceImpl implements IListenService {
    @Autowired
    private IListenRepository iListenRepository;
    @Override
    public List<Listen> findAll() {
        return iListenRepository.findAll();
    }

    @Override
    public Listen findById(int id) {
        return iListenRepository.findById(id);
    }

    @Override
    public void create(Listen listen) {
        iListenRepository.create(listen);
    }

    @Override
    public void update(int id, Listen listen) {
        iListenRepository.update(id,listen);
    }

    @Override
    public void delete(int id) {
        iListenRepository.delete(id);
    }

    @Override
    public List<Listen> search(String name) {
        return iListenRepository.search(name);
    }
}
