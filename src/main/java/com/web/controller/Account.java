package com.web.controller;

import com.web.service.ProductService;
import com.web.service.impl.ProductImpl;
import com.web.entity.Product;
import com.web.service.CookieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Account {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = "/account")
    public String account(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
//        ProductImpl productImpl = new ProductImpl();
        List<Product> productList = productService.getProductList();
        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();
                ) {
            Product product = iterator.next();
            if (product.getIsBuy() == false) {//未购买内容删除
                iterator.remove();
            }
        }
        modelMap.addAttribute("buyList", productList);
        return "account";
    }
}
