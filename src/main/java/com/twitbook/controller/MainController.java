package com.twitbook.controller;

import com.twitbook.security.CustomUserDetails;
import com.twitbook.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final String MAIN_PATH_NAME = "main";
    private static final String LOGIN_FORM_PATH_NAME = "login";
    private static final String SIGNUP_FORM_PATH_NAME = "signUp";

    @Autowired
    PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewMain(ModelMap map, @AuthenticationPrincipal CustomUserDetails account) {
        if(account != null) {
            map.addAttribute("account", account);
        }
        map.addAttribute("postList", postService.getAllList());
        return MAIN_PATH_NAME;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLoginPage(ModelMap map) {
        map.addAttribute("account", new CustomUserDetails());
        return LOGIN_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String viewSignUpPage(ModelMap map) {
        map.addAttribute("account", new CustomUserDetails());
        map.addAttribute("action", "create");
        return SIGNUP_FORM_PATH_NAME;
    }
}
