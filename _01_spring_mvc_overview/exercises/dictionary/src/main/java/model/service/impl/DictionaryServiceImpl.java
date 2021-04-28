package model.service.impl;

import model.repository.impl.DictionaryRepositoryImpl;
import model.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    public DictionaryServiceImpl(){

    }
    @Override
    public String search(String string) {
        String result = DictionaryRepositoryImpl.dictionary.get(string);
        boolean check = result != null;
            if (check){
                return result;
        }
        return "Not found";
    }
}
