package com.web.controller.api;

import com.web.service.ContentService;
import com.web.service.impl.ContentImpl;
import com.web.service.CookieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mew on 2017/7/9.
 */
@Controller
public class ApiDelete {
    private ContentService contentService;

    @Autowired
    public void setProductService(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/api/delete")
    @ResponseBody
    public ModelMap Upload(@RequestParam("id") int id, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        CookieInfo cookieInfo = new CookieInfo(request);
//        ContentImpl contentImpl = new ContentImpl();
        if (cookieInfo.isCookieUser() && cookieInfo.getCookieUser().getUserName().equals("seller")) {
            contentService.deleteContent(id);
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result", true);
        } else {
            map.addAttribute("code", 400);
            map.addAttribute("message", "你不是管理员");
            map.addAttribute("result", false);
        }
        return map;
    }
}

