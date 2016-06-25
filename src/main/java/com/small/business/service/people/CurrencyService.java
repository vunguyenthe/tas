package com.small.business.service.people;

import java.util.List;

import com.small.business.model.people.Currency;

public interface CurrencyService {

    public List<Currency> getAllCurrency();

    public Currency getCurrencyById(Long id);

    public boolean addCurrency(Currency peopleDocument);

    public boolean addListCurrency(List<Currency> listCurrency);

    public boolean updateListCurrency(List<Currency> listCurrency);

    public boolean deleteCurrencyById(Long id);

    public boolean deleteAll();

    public boolean updateCurrency(Currency peopleDocument);
}
