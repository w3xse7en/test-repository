package com.web.controller;

import com.web.dao.PersonDao;
import com.web.entity.Person;
import com.web.service.CookieInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Login {
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
        CookieInfo cookieInfo = new CookieInfo(request);
        Cookie userNameCookie = new Cookie("loginUserName", cookieInfo.getCookieUser().getUserName());
        Cookie userTypeCookie = new Cookie("loginUserType", "" + cookieInfo.getCookieUser().getUserType());
        userNameCookie.setMaxAge(0);
        userNameCookie.setPath("/");
        userTypeCookie.setMaxAge(0);
        userTypeCookie.setPath("/");
        response.addCookie(userNameCookie);
        response.addCookie(userTypeCookie);
        return "redirect:/";
    }
}
