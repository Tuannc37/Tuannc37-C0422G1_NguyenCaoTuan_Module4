package example.service.impl;

import example.repository.IDictionaryRepository;
import example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    public String findAll(String str) {
        return dictionaryRepository.findAll(str);
    }
}
