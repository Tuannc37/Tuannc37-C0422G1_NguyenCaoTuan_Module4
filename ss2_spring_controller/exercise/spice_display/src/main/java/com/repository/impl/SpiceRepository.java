package com.repository.impl;

import org.springframework.stereotype.Service;
import com.repository.ISpiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpiceRepository implements ISpiceRepository {
    private static List<String> spiceList = new ArrayList<>();

    static {
        spiceList.add("Lettuce");
        spiceList.add("Tomato");
        spiceList.add("Mustard");
        spiceList.add("Sprouts");
    }

    @Override
    public List<String> findAll() {
        return spiceList;
    }
}
