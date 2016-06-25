package com.small.business.service.people;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.people.CurrencyDao;
import com.small.business.model.people.Currency;

@Service("CurrencyService")
public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger logger = LoggerFactory
            .getLogger(CurrencyServiceImpl.class);
    private static List<Currency> currencyList = new ArrayList<Currency>();
    private static Long id = 0L;

    @Autowired
    CurrencyDao currencyDao;

    public List<Currency> getAllCurrency() {

        List<Currency> currencyList = currencyDao.getAllCurrency();
        return currencyList;
    }

    public Currency getCurrencyById(Long id) {

        return currencyDao.getCurrencyById(id);
    }

    public boolean addCurrency(Currency peopleJournal) {

        peopleJournal.setId(++id);
        return currencyDao.addCurrency(peopleJournal);
    }

    public boolean deleteCurrencyById(Long id) {

        boolean ret = false;
        ret = currencyDao.deleteCurrencyById(id);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        currencyList.clear();
        id = 0L;
        return currencyDao.deleteAll();
    }

    public boolean updateListCurrency(List<Currency> listCurrency) {

        return currencyDao.updateListCurrency(listCurrency);
    }

    public boolean addListCurrency(List<Currency> listCurrency) {

        return currencyDao.addListCurrency(listCurrency);
    }

    public boolean updateCurrency(Currency peopleHistory) {

        Currency foundCurrency = getCurrencyById(peopleHistory.getId());
        if (foundCurrency != null) {
            currencyList.remove(foundCurrency);
            currencyList.add(peopleHistory);
        }
        return currencyDao.updateCurrency(peopleHistory);

    }

}
