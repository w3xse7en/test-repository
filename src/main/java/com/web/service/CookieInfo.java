package com.web.service;

import com.web.entity.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Mew on 2017/7/2.
 */
public class CookieInfo {
    private HttpServletRequest request;
    private Person person = new Person();

    public CookieInfo(HttpServletRequest request) {
        this.request = request;
    }

    public Person getCookieUser() {
        return person;
    }

    public boolean isCookieUser() {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            boolean flag1 = false;
            boolean flag2 = false;
            for (Cookie cookie : cookies) {
                if ("loginUserName".equals(cookie.getName())) {
                    person.setUserName(cookie.getValue());
                    flag1 = true;
                } else if ("loginUserType".equals(cookie.getName())) {
                    person.setUserType(Integer.parseInt(cookie.getValue()));
                    flag2 = true;
                }
            }
            if (flag1 && flag2) {
                return true;
            }
        }
        return false;
    }
}
