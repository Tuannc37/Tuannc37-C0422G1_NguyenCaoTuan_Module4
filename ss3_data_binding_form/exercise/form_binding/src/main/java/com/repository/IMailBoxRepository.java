package com.repository;

import java.util.List;

public interface IMailBoxRepository {
    public List<String> findLanguage();
    public List<Integer> findPageSize();
}
