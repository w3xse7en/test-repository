package com.web.service;

/**
 * Created by Mew on 2017/7/29.
 */
public interface PersonService {
    boolean isUser(String userName, String userPassword);

    int getType(String userName);

    String getuserPassword(String userName);

}
