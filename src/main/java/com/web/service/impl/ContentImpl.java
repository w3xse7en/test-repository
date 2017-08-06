package com.web.service.impl;

import com.web.dao.ContentDao;
import com.web.entity.Content;
import com.web.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Mew on 2017/7/6.
 */
@Service
public class ContentImpl implements ContentService {
    //    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
//    ContentDao dao = context.getBean(ContentDao.class);
    private ContentDao contentDao;

    @Autowired
    public void setDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    public Content getAndInsertContent(Double price, String title, String pic, String summary, String detail) {
        Content content = new Content();
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(pic);
        content.setSummary(summary);
        content.setDetail(detail);
        contentDao.insertPublic(content);
        content.setId(contentDao.getContentId(price, title, pic, summary, detail));
        return content;
    }

    public void updateContent(Content content) {
        contentDao.updateContent(content);
    }

    public Content getContent(int id) {
        return contentDao.getContent(id);
    }

    public void deleteContent(int id) {
        contentDao.deleteContent(id);
    }

    ;
}
