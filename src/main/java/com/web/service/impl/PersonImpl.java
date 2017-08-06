package com.web.service.impl;

import com.web.dao.PersonDao;
import com.web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mew on 2017/7/1.
 */
@Service
public class PersonImpl implements PersonService {
    //    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//    PersonDao dao = context.getBean(PersonDao.class);
    private PersonDao personDao;

    @Autowired
    public void setDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean isUser(String userName, String userPassword) {
        if (userPassword.equals(personDao.getuserPassword(userName))) {
            return true;
        }
        return false;
    }

    public int getType(String userName) {
        return personDao.getuserType(userName);
    }

    public String getuserPassword(String userName) {
        return personDao.getuserPassword(userName);
    }
}
