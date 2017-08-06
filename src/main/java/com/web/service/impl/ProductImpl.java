package com.web.service.impl;

import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.entity.Transaction;
import com.web.service.ProductService;
import com.web.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
@Service
public class ProductImpl implements ProductService {
    //    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//    ProductDao dao = context.getBean(ProductDao.class);
    private ProductDao productDao;
    private TransactionService transactionService;

    @Autowired
    public void setDao(ProductDao productDao, TransactionService transactionService) {
        this.productDao = productDao;
        this.transactionService = transactionService;
    }

    public List<Product> getProductList() {
        List<Product> productList = productDao.getProductList();
//        TransactionImpl transactionImpl = new TransactionImpl();
        for (Product product : productList) {
            setProductInfo(transactionService, product);
        }
        return productList;
    }

    public Product getProduct(int id) {
//        TransactionImpl transactionImpl = new TransactionImpl();
        Product product = productDao.getProduct(id);
        setProductInfo(transactionService, product);
        return product;
    }

    public void setProductInfo(TransactionService transactionService, Product product) {
        Transaction transaction = null;
        if (null != (transaction = transactionService.getTransaction(product.getId()))) {
            product.setIsBuy(true);
            product.setIsSell(true);
            product.setBuyPrice(transaction.getPrice());
            product.setBuyNum(transaction.getNum());
            product.setTime(transaction.getTime());
        } else {
            product.setIsBuy(false);
            product.setIsSell(false);
        }
    }
}
