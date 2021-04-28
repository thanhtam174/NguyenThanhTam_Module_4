package model.service.impl;

import model.service.CurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    public CurrencyServiceImpl(){

    }
    @Override
    public Double convert(Double usd, Double rate) {
        return usd*rate;
    }
}
