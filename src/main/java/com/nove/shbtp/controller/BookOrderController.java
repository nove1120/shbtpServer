package com.nove.shbtp.controller;


import com.nove.shbtp.dao.BookDao;
import com.nove.shbtp.dao.BookOrderDao;
import com.nove.shbtp.pojo.Book;
import com.nove.shbtp.pojo.BookOrder;
import com.nove.shbtp.service.BookOrderService;
import com.nove.shbtp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookOrderController {

    @Autowired
    BookOrderService bookOrderService;

    @ResponseBody
    @RequestMapping("/bookOrderUpload")
    public BookOrder bookOrderUpload(@RequestBody BookOrder bookOrder){
        System.out.println(bookOrder);
        bookOrder.setState(1);
        return bookOrderService.addBookOrder(bookOrder);
    }

    @ResponseBody
    @RequestMapping("/bookOrderUpdate")
    public int bookOrderUpdate(@RequestBody BookOrder bookOrder){
        return bookOrderService.updateBookOrder(bookOrder);
    }

    @ResponseBody
    @RequestMapping("/bookOrderDelete")
    public int bookOrderUpdate(int oid){
        return bookOrderService.deleteBookOrder(oid);
    }

    @ResponseBody
    @RequestMapping("/getOrderByBuyerUid")
    public List<BookOrder> getOrderBuyerByUid(int uid){
        System.out.println(uid);
        System.out.println(bookOrderService.getBookOrderByBuyerUid(uid));
        return bookOrderService.getBookOrderByBuyerUid(uid);
    }

    @ResponseBody
    @RequestMapping("/getOrderBySellerUid")
    public List<BookOrder> getOrderBySellerUid(int uid){
        return bookOrderService.getBookOrderBySellerUid(uid);
    }
}
