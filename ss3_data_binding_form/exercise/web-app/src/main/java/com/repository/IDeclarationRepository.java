package com.repository;

import com.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Declaration> findAll();

    public List<String> gender();

    public List<String> nationality();

    public List<Integer> day();

    public List<Integer> month();

    public List<Integer> year();

    Declaration findById(int id);

    void create(Declaration declaration);

    void update(int id, Declaration declaration);

}
