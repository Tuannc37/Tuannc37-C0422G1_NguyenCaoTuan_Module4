package com.repository;

import com.model.Listen;

import java.util.List;

public interface IListenRepository {
    List<Listen> findAll();

    Listen findById(int id);

    void create(Listen listen);

    void update(int id, Listen listen);

    void delete(int id);

    List<Listen> search(String name);
}
