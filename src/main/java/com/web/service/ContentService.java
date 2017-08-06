package com.web.service;

import com.web.entity.Content;

/**
 * Created by Mew on 2017/7/29.
 */
public interface ContentService {
    Content getAndInsertContent(Double price, String title, String pic, String summary, String detail);

    void updateContent(Content contentService);

    Content getContent(int id);

    void deleteContent(int id);

}
