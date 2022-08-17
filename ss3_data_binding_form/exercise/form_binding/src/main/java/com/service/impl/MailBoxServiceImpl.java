package com.service.impl;

import com.model.MailBox;
import com.repository.IMailBoxRepository;
import com.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxServiceImpl implements IMailBoxService {
    @Autowired
    private IMailBoxRepository iMailBoxRepository;

    @Override
    public List<String> findLanguage() {
        return iMailBoxRepository.findLanguage();
    }

    @Override
    public List<Integer> findPageSize() {
        return iMailBoxRepository.findPageSize();
    }

}
