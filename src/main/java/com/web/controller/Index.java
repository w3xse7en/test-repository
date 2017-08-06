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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class Index {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping(value = {"/", "/index", ""})
    public String index(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "type", required = false) Integer type) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        if (null == type) {
            type = 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("type", type);
        modelMap.addAttribute("RequestParameters", map);

//        ProductImpl productImpl = new ProductImpl();
        List<Product> productList = productService.getProductList();
        if (type.equals(1)) {
            for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();
                    ) {
                Product product = iterator.next();
                if (product.getIsBuy() == true) {//已购买内容删除
                    iterator.remove();
                }
            }
        }
        modelMap.addAttribute("productList", productList);
        return "index";
    }
}
