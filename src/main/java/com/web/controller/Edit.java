package com.web.controller;

import com.web.service.ProductService;
import com.web.service.impl.ProductImpl;
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
public class Edit {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        if (id != null) {
//            ProductImpl productImpl = new ProductImpl();
            modelMap.addAttribute("product", productService.getProduct(id));
        }
        return "edit";
    }
}
