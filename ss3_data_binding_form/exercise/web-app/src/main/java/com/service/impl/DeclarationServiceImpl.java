package com.service.impl;

import com.model.Declaration;
import com.repository.IDeclarationRepository;
import com.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationServiceImpl implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;


    @Override
    public List<Declaration> findAll() {
        return iDeclarationRepository.findAll();
    }

    @Override
    public List<String> gender() {
        return iDeclarationRepository.gender();
    }

    @Override
    public List<String> nationality() {
        return iDeclarationRepository.nationality();
    }

    @Override
    public List<Integer> day() {
        return iDeclarationRepository.day();
    }

    @Override
    public List<Integer> month() {
        return iDeclarationRepository.month();
    }

    @Override
    public List<Integer> year() {
        return iDeclarationRepository.year();
    }

    @Override
    public Declaration findById(int id) {
        return iDeclarationRepository.findById(id);
    }

    @Override
    public void create(Declaration declaration) {
        iDeclarationRepository.create(declaration);
    }

    @Override
    public void update(int id, Declaration declaration) {
        iDeclarationRepository.update(id,declaration);
    }
}
