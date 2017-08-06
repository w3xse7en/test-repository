package com.web.controller.api;

import com.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class ApiLogin {
    //    PersonImpl personImpl = new PersonImpl();
    private PersonService personService;

    @Autowired
    public void setProductService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/api/login")
    @ResponseBody
    public ModelMap Login(@RequestParam("userName") String userName, @RequestParam("password") String password, ModelMap map, HttpServletResponse response) {
        System.out.println(userName + ":" + password);
        if (personService.isUser(userName, password)) {
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result", true);
            Cookie userNameCookie = new Cookie("loginUserName", userName);
            Cookie userTypeCookie = new Cookie("loginUserType", "" + personService.getType(userName));
            userNameCookie.setPath("/");
            userTypeCookie.setPath("/");
            userNameCookie.setMaxAge(60 * 60);
            userTypeCookie.setMaxAge(60 * 60);
            response.addCookie(userNameCookie);
            response.addCookie(userTypeCookie);
        } else {
            map.addAttribute("code", 401);
            map.addAttribute("message", "账号密码错误");
            map.addAttribute("result", false);
        }
        return map;
    }

}
