package com.service;

import com.model.Listen;

import java.util.List;

public interface IListenService {
    List<Listen> findAll(String name);

    Listen findById(int id);

    void create(Listen listen);

    void update(int id, Listen listen);

    void delete(int id);

}
