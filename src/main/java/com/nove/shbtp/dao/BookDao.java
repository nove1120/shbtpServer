package com.nove.shbtp.dao;

import com.nove.shbtp.dto.BookSelectParam;
import com.nove.shbtp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface BookDao {
    Book selectBookByBid(int bid);
    Book selectBookByUid(int uid);
    List<Book> selectBook(BookSelectParam bookSelectParam);
    int addBook(Book book);
    int updateBook(Book book);
    int deleteBook(int bid);
    Date selectUpdateTime(int bid);
}
