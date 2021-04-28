package model.repository.impl;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryRepositoryImpl{
    public static Map<String,String> dictionary;
    static {
        dictionary = new TreeMap<>();
        dictionary.put("hello","Xin chào");
        dictionary.put("love","yêu");
        dictionary.put("money","Tiền");
        dictionary.put("car","Xe hơi");
        dictionary.put("water","nước");
    }

}
