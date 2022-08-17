package com.repository.impl;

import com.model.MailBox;
import com.repository.IMailBoxRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MailBoxRepositoryImpl implements IMailBoxRepository {

    @Override
    public List<String> findLanguage() {
        List<String> language = new LinkedList<>();
        language.add("English");
        language.add("Vietnamese");
        language.add("Chinese");
        language.add("Japanese");
        return language;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> findPage = new LinkedList<>();
        findPage.add(5);
        findPage.add(10);
        findPage.add(15);
        findPage.add(25);
        findPage.add(50);
        findPage.add(100);
        return findPage;
    }
}
