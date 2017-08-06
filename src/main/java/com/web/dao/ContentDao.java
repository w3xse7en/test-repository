package com.web.dao;

import com.web.entity.Content;
import org.apache.ibatis.annotations.*;

/**
 * Created by Mew on 2017/7/6.
 */
public interface ContentDao {
    @Insert("insert into content (price,title,icon,abstract,text) VALUES(#{price},#{title},#{pic},#{summary},#{detail});")
    void insertPublic(Content content);

//        @Select("select id from content where price = #{0} and title = #{1} and icon = #{2} and abstract = #{3} and text = #{4}")
//    上面的语句用于云服务器
    @Select("select id from content where price = #{arg0} and title = #{arg1} and icon = #{arg2} and abstract = #{arg3} and text = #{arg4}")
    int getContentId(Double price, String title, String pic, String summary, String detail);

    @Select("select * from content where id = #{id}")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text")
    })
    Content getContent(int id);

    @Update("update content set price = #{price}, title = #{title}, icon = #{pic}, abstract = #{summary}, text = #{detail} where id = #{id}")
    void updateContent(Content content);

    @Delete("delete from content where id = #{id}")
    void deleteContent(int id);
}
