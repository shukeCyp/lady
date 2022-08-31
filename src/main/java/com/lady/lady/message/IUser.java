package com.lady.lady.message;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IUser {

    @RequestMapping(value = "/message/register",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String register(String username,String password);

    @RequestMapping(value = "/message/login",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String login(String username,String password);
}
