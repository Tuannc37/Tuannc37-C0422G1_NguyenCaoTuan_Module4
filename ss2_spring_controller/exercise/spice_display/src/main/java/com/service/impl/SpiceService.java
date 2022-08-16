package com.service.impl;

import com.repository.ISpiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.ISpiceService;
import java.util.List;

@Service
public class SpiceService implements ISpiceService {

    @Autowired
    private ISpiceRepository iSpiceRepository;
    @Override
    public List<String> findAll() {
        return iSpiceRepository.findAll();
    }
}
