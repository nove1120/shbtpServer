package com.nove.shbtp.service;

import com.nove.shbtp.dao.BookDao;
import com.nove.shbtp.dao.BookDescDao;
import com.nove.shbtp.dto.BookSelectParam;
import com.nove.shbtp.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Autowired
    BookDescDao bookDescDao;

    @Transactional(rollbackFor = {Exception.class})
    public Book addBook(Book book){
        if (book != null && book.getBookDesc() != null) {
            try {
                bookDao.addBook(book);
                book.getBookDesc().setBid(book.getBid());
                bookDescDao.addBookDesc(book.getBookDesc());
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("事务回滚");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;
            }
            return book;
        } else {
            return null;
        }

    }

    public Book selectBookByBid(int bid){
            return bookDao.selectBookByBid(bid);
    }
    public Book selectBookByUid(int uid){
        return bookDao.selectBookByUid(uid);
    }

    public List<Book> selectBook(BookSelectParam bookSelectParam){
        if(bookSelectParam!=null) {
            bookSelectParam.setState(0);
            return bookDao.selectBook(bookSelectParam);
        }
        return null;
    }
    @Transactional(rollbackFor = {Exception.class})
    public int updateBook(Book book){
        int i=0,j=0;
        try {
            if (book != null) {
                i = bookDao.updateBook(book);
            }
            if (book.getBookDesc() != null) {
                j = bookDescDao.updateBookDese(book.getBookDesc());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        if(i>0&&j>0){
            return 1;
        }else{
            return 0;
        }
    }
    @Transactional(rollbackFor = {Exception.class})
    public boolean deleteBook(int bid){
        int i=0,j=0;
        try {
            i = bookDao.deleteBook(bid);
            j = bookDescDao.deleteBookDesc(bid);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        if(i>0||j>0){
            return true;
        }else{
            return false;
        }
    }

}
