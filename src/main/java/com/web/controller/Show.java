package com.web.controller;

import com.web.service.ProductService;
import com.web.service.impl.ProductImpl;
import com.web.entity.Product;
import com.web.service.CookieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Show {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService){ this.productService = productService;}
    @RequestMapping(value = "/show")
    public String show(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam("id") int id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());

        }
//        ProductImpl productImpl = new ProductImpl();
        Product product = productService.getProduct(id);
        modelMap.addAttribute("product", product);
        return "show";
    }
}
