package com.web.service;

import com.web.entity.Transaction;

/**
 * Created by Mew on 2017/7/29.
 */
public interface TransactionService {
    Transaction getTransaction(int id);

    void InsertTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);
}
