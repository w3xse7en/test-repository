package com.web.controller;

import com.web.service.ContentService;
import com.web.service.impl.ContentImpl;
import com.web.entity.Content;
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
public class PublicSubmit {
    private ContentService contentService;

    @Autowired
    public void setProductService(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/publicSubmit")
    public String publicSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
                               @RequestParam("price") Double price, @RequestParam("title") String title,
                               @RequestParam("image") String pic, @RequestParam("summary") String summary,
                               @RequestParam("detail") String detail
    ) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
//        ContentImpl contentImpl = new ContentImpl();
        if (pic.length() > 100 || price > Double.MAX_VALUE) {
            return "publicSubmit";
        }
        Content content = contentService.getAndInsertContent(price, title, pic, summary, detail);
        modelMap.addAttribute("product", content);

        return "publicSubmit";
    }
}
