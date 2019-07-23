package com.twitbook.controller;

import com.twitbook.domain.Account.Account;
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
    private static final String REDIRECT_TO_MAIN = "redirect:/";

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAccountList(ModelMap map) {
        map.addAttribute("userList", accountService.findAll());
        return USER_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/login/check", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute("account") Account account) {

        return REDIRECT_TO_MAIN;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String viewSignUpPage(ModelMap map) {
        map.addAttribute("account", new Account());
        map.addAttribute("action", "create");
        return SIGNUP_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String registerAccount(@ModelAttribute("account") Account account) {
        accountService.insert(account);
        return REDIRECT_TO_MAIN;
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyAccount(@PathVariable Long id, ModelMap map) {
        map.addAttribute("account", accountService.findById(id));
        map.addAttribute("action", "update");
        return SIGNUP_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") Account account) {
        accountService.update(account);
        return REDIRECT_TO_MAIN;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return REDIRECT_TO_MAIN;
    }
}
