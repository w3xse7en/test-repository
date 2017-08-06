package com.web.service.impl;

import com.web.dao.TransactionDao;
import com.web.entity.Transaction;
import com.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Mew on 2017/7/8.
 */
@Service
public class TransactionImpl implements TransactionService {
//    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//    TransactionDao dao = context.getBean(TransactionDao.class);
    private TransactionDao transactionDao;
    @Autowired
    public void setDao(TransactionDao transactionDao){
        this.transactionDao = transactionDao;
    }

    public Transaction getTransaction(int id) {
        return transactionDao.getTransaction(id);
    }

    public void InsertTransaction(Transaction transaction) {
        transactionDao.InsertTransaction(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        transactionDao.updateTransaction(transaction);
    }
}
