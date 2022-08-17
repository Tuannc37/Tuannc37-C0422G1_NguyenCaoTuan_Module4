package com.service;

import com.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    public List<String> findLanguage();
    public List<Integer> findPageSize();
}
