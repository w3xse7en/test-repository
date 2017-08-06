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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mew on 2017/6/30.
 */
@Controller
public class EditSubmit {
    private ContentService contentService;

    @Autowired
    public void setProductService(ContentService contentService) {
        this.contentService = contentService;
    }
    @RequestMapping(value = "/editSubmit")
    public String editSubmit(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
                             @RequestParam("price") Double price, @RequestParam("title") String title,
                             @RequestParam("image") String pic, @RequestParam("summary") String summary,
                             @RequestParam("detail") String detail, @RequestParam(value = "id", required = true) Integer id) {
        CookieInfo cookieInfo = new CookieInfo(request);
        if (cookieInfo.isCookieUser()) {
            modelMap.addAttribute("user", cookieInfo.getCookieUser());
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("id", id);
        modelMap.addAttribute("RequestParameters", map);
        if(pic.length()>100||price>Double.MAX_VALUE){
            return "editSubmit";
        }
//        ContentImpl contentImpl = new ContentImpl();
        Content content = contentService.getContent(id);
        //修改原数据
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(pic);
        content.setSummary(summary);
        content.setDetail(detail);

        contentService.updateContent(content);
        content = contentService.getContent(id);
        modelMap.addAttribute("product", content);
        return "editSubmit";
    }
}
