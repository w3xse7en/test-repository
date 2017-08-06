package com.web.dao;

import com.web.entity.Product;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mew on 2017/7/8.
 */
public interface ProductDao {
    @Select("select * from content")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text")
    })
    List<Product> getProductList();

    @Select("select * from content where id = #{id}")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text")
    })
    Product getProduct(int id);
}
