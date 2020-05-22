package com.nove.shbtp.service;

import com.nove.shbtp.dao.BookDao;
import com.nove.shbtp.dao.BookOrderDao;
import com.nove.shbtp.dao.UserDao;
import com.nove.shbtp.pojo.Book;
import com.nove.shbtp.pojo.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookOrderServiceImpl implements BookOrderService{

    @Autowired
    BookOrderDao bookOrderDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    UserDao userDao;

    @Transactional(rollbackFor = {Exception.class})
    public BookOrder addBookOrder(BookOrder bookOrder){
        if(bookOrder!=null) {
            Book book = bookDao.selectBookByBid(bookOrder.getBid());
            if (book.getState() != 0) {
                return null;
            }
            bookOrderDao.addBookOrder(bookOrder);
            book.setState(1);
            int n = bookDao.updateBook(book);
            if (n == 1) {
                return bookOrder;
            }
        }
        return null;
    }

    public int updateBookOrder(BookOrder bookOrder){
        if(bookOrder!=null){
            System.out.println(bookOrder);
            return bookOrderDao.updateBookOrder(bookOrder);
        }
        return 0;
    }

    public int deleteBookOrder(int oid){
        return bookOrderDao.deleteBookOrder(oid);
    }

    public List<BookOrder> getBookOrderByBuyerUid(int uid){
        return bookOrderDao.selectBookOrderByBuyerUid(uid);
    }
    public List<BookOrder> getBookOrderBySellerUid(int uid){
        return bookOrderDao.selectBookOrderBySellerUid(uid);
    }
}
