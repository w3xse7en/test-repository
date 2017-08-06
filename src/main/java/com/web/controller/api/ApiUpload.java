package com.web.controller.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mew on 2017/7/6.
 */
@Controller
public class ApiUpload {
    @RequestMapping(value = "/api/upload")
    @ResponseBody
    public ModelMap Upload(@RequestParam("file") MultipartFile file, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadPicture");
        String fileName = Integer.toString(file.getOriginalFilename().hashCode()) + ".jpg";
//        System.out.println("fileName:"+fileName+" "+file.getOriginalFilename().hashCode());
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (fileType.toLowerCase().equals("jpg")) {
            String webFileNamePath = "/uploadPicture/" + fileName;
            String realFileNamePath = realPath + "/" + fileName;
            try {
                file.transferTo(new File(realFileNamePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(realFileNamePath);
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result", webFileNamePath);
            return map;
        }
        map.addAttribute("code", 400);
        map.addAttribute("message", "error");
        return map;
    }

}
