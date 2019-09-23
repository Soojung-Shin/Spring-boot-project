package com.twitbook.controller;

import com.twitbook.security.CustomUserDetails;
import com.twitbook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    private static final String USER_LIST_PATH_NAME = "userList";
    private static final String SIGNUP_FORM_PATH_NAME = "signUp";
    private static final String LOGIN_FORM_PATH_NAME = "login";
    private static final String MYINFO_PATH_NAME = "profileModify";
    private static final String REDIRECT_TO_MAIN = "redirect:/";
    private static final String REDIRECT_TO_LOGIN = "redirect:/login";


    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") CustomUserDetails account) {
        accountService.insert(account);
        return REDIRECT_TO_LOGIN;
    }

    @RequestMapping(value = "/myInfo", method = RequestMethod.GET)
    public String myInfo() {
        return MYINFO_PATH_NAME;
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyAccount(@PathVariable Long id, ModelMap map) {
        map.addAttribute("account", accountService.findById(id));
        map.addAttribute("action", "update");
        return SIGNUP_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") CustomUserDetails account) {
        accountService.update(account);
        return REDIRECT_TO_MAIN;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return REDIRECT_TO_MAIN;
    }
}
