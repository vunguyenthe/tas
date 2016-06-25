package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.model.people.Currency;
import com.small.business.service.people.CurrencyService;

@Controller
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @RequestMapping(value = "/currency/{id}", method = RequestMethod.GET)
    public @ResponseBody Currency getCurrency(@PathVariable long id) {

        return currencyService.getCurrencyById(id);
    }

    @RequestMapping(value = "/currency", method = RequestMethod.GET)
    public @ResponseBody List<Currency> getCurrencyList() {

        return currencyService.getAllCurrency();
    }

    @RequestMapping(value = "/currency", method = RequestMethod.POST)
    public @ResponseBody boolean addCurrency(@RequestBody Currency currency) {

        return currencyService.addCurrency(currency);
    }

    @RequestMapping(value = "/currency", method = RequestMethod.PUT)
    public @ResponseBody boolean updateCurrency(@RequestBody Currency currency) {

        return currencyService.updateCurrency(currency);
    }

    @RequestMapping(value = "/currency/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeCurrency(@PathVariable("id") Long id) {

        return currencyService.deleteCurrencyById(id);
    }

    @RequestMapping(value = "/removeAllCurrency", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllCurrency() {

        return currencyService.deleteAll();
    }
}
