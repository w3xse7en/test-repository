package com.web.service;

import com.web.entity.Product;
import com.web.entity.Transaction;

import java.util.List;

/**
 * Created by Mew on 2017/7/29.
 */
public interface ProductService {
    List<Product> getProductList();

    Product getProduct(int id);

    void setProductInfo(TransactionService transactionService, Product product);
}
