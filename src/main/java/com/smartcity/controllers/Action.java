package com.smartcity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZJDX on 2016/6/26.
 */
@RestController
public class Action {
    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public String application(){
        return "http://localhost:8080/index.html";
    }

}
