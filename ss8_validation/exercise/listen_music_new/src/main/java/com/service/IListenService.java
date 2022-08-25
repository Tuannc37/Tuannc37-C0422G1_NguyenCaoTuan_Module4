package com.service;

import com.model.Listen;

import java.util.List;
import java.util.Optional;

public interface IListenService {
    List<Listen> findAll();

    void create(Listen listen);

    void update(Listen listen);

    Optional<Listen> findId(int id);
}
