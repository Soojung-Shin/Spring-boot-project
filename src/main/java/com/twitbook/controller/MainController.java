package com.twitbook.controller;

import com.twitbook.domain.Account.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final String MAIN_PATH_NAME = "main";
    private static final String LOGIN_FORM_PATH_NAME = "login";

    @RequestMapping(method = RequestMethod.GET)
    public String viewMain() {
        return MAIN_PATH_NAME;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLoginPage(ModelMap map) {
        map.addAttribute("account", new Account());
        return LOGIN_FORM_PATH_NAME;
    }
}
