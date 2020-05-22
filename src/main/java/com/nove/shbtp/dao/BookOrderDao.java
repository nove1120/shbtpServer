package com.nove.shbtp.dao;

import com.nove.shbtp.pojo.BookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookOrderDao {
    int addBookOrder(BookOrder bookOrder);
    List<BookOrder> selectBookOrderBySellerUid(int uid);
    List<BookOrder> selectBookOrderByBuyerUid(int uid);
    BookOrder selectBookOrderByOid(int uid);
    int updateBookOrder(BookOrder bookOrder);
    int deleteBookOrder(int oid);
}
