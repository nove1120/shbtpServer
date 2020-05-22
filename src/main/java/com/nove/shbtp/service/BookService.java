package com.nove.shbtp.service;

import com.nove.shbtp.dto.BookSelectParam;
import com.nove.shbtp.pojo.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    Book selectBookByBid(int bid);
    Book selectBookByUid(int uid);
    List<Book> selectBook(BookSelectParam bookSelectParam);
    int updateBook(Book book);
    boolean deleteBook(int bid);
}
