package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.Currency;

public interface CurrencyDao {

    public List<Currency> getAllCurrency();

    public Currency getCurrencyById(Long id);

    public boolean addListCurrency(List<Currency> listCurrency);

    public boolean updateListCurrency(List<Currency> listCurrency);

    public boolean addCurrency(Currency currency);

    public boolean deleteCurrencyById(Long id);

    public boolean deleteAll();

    public boolean updateCurrency(Currency currency);
}
