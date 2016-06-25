package com.small.business.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping
    public String getIndexPage() {

        return "index";
    }
}
