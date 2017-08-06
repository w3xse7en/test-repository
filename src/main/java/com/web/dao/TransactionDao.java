package com.web.dao;

import com.web.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Mew on 2017/7/8.
 */
public interface TransactionDao {
    @Select("SELECT * FROM trx where contentId = #{id};")
    Transaction getTransaction(int id);

    @Insert("insert into trx (contentId,personId,price,num,time) VALUES(#{contentId},#{personId},#{price},#{num},#{time});")
    void InsertTransaction(Transaction transaction);

    @Update("update trx set price = #{price},num = #{num},time = #{time} where id = #{id}")
     void updateTransaction(Transaction transaction);
}
