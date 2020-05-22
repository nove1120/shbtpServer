package com.nove.shbtp.dao;

import com.nove.shbtp.pojo.Book;
import com.nove.shbtp.pojo.BookDesc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDescDao {


    int addBookDesc(BookDesc bookDesc);
    BookDesc selectBookDescByBid(int bid);
    List<BookDesc> selectAllBookDesc();
    int updateBookDese(BookDesc bookDesc);
    int deleteBookDesc(int bid);
}
