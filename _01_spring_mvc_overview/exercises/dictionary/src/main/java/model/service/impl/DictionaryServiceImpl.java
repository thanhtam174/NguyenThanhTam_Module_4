package model.service.impl;

import model.repository.impl.DictionaryRepositoryImpl;
import model.service.DictionaryService;

import java.util.Set;

public class DictionaryServiceImpl implements DictionaryService {
    Set<String> keySet = DictionaryRepositoryImpl.dictionary.keySet();

    public DictionaryServiceImpl(){

    }
    @Override
    public String search(String string) {
        for (String key:keySet) {
            if (string.equals(key)){
                return DictionaryRepositoryImpl.dictionary.get(key);
            }
        }
        return "Not found";
    }
}
