package example.repository.impl;

import example.repository.IDictionaryRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryRepositoryImpl implements IDictionaryRepository {
    private static Map<String, String> dictionaries = new HashMap<>();

    static {
        dictionaries.put("hello", "Xin chào");
        dictionaries.put("dog", "Con chó");
        dictionaries.put("cat", "Con mèo");
        dictionaries.put("book", "Quyển vở");
        dictionaries.put("goodbye", "Tạm biet");
        dictionaries.put("mouse", "Con chuột");
    }

    @Override
    public String findAll(String str) {
        String result = "";
        for (Map.Entry<String, String> d : dictionaries.entrySet()) {
            if(str.equalsIgnoreCase(d.getKey())){
                result = d.getValue();
            }
        }
        if(result == ""){
            result = "Không tìm thấy";
        }
        return result;
    }
}
