package com.nove.shbtp.service;

import com.nove.shbtp.dto.BookSelectParam;
import com.nove.shbtp.pojo.Book;
import com.nove.shbtp.pojo.BookOrder;

import java.util.List;

public interface BookOrderService {
    public BookOrder addBookOrder(BookOrder bookOrder);
    public int updateBookOrder(BookOrder bookOrder);
    public int deleteBookOrder(int oid);
    public List<BookOrder> getBookOrderByBuyerUid(int uid);
    public List<BookOrder> getBookOrderBySellerUid(int uid);
}
