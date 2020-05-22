package com.nove.shbtp.controller;


import com.nove.shbtp.dao.BookDao;
import com.nove.shbtp.dto.BookSelectParam;
import com.nove.shbtp.pojo.Book;
import com.nove.shbtp.pojo.BookOrder;
import com.nove.shbtp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookDao bookDao;
    @ResponseBody
    @RequestMapping("/bookUpload")
    public String bookUpload(@RequestBody Book book){
        System.out.println("book:"+book);
        Book newBook = bookService.addBook(book);
        System.out.println(newBook.getBid());
        if(newBook!=null)
            return ""+newBook.getBid();
        else
            return null;
    }


    @ResponseBody
    @RequestMapping("/bookImageUpload")
    public String bookImageUpload(MultipartFile[] files , int bid,HttpServletRequest req){

//        // 判断文件是否为空，空则返回失败页面
//        if (files.length==0||bid==0) {
//            return "false";
//        }
//        for(MultipartFile file:files) {
//            // 获取文件存储路径（绝对路径）
//            String path = req.getServletContext().getRealPath("/WEB-INF/bookImage/"+bid+"/");
//            // 获取原文件名
//            String fileName = file.getOriginalFilename();
//            // 创建文件实例
//            File filePath = new File(path, fileName);
//            // 如果文件目录不存在，创建目录
//            if (!filePath.getParentFile().exists()) {
//                filePath.getParentFile().mkdirs();
//                System.out.println("创建目录" + filePath);
//            }
//            // 写入文件
//            try {
//                file.transferTo(filePath);
//            }catch (Exception e){
//                e.printStackTrace();
//                return "false";
//            }
//        }
//        return "true";


        // 判断文件是否为空，空则返回失败页面
        if (files.length==0||bid==0) {
            return "false";
        }
        for(MultipartFile file:files) {
            // 获取文件存储路径（绝对路径）
            String path = "D:\\shbtpFile\\bookImage\\"+bid;
            // 获取原文件名
            String fileName = file.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(path, fileName);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);
            }
            // 写入文件
            try {
                file.transferTo(filePath);
            }catch (Exception e){
                e.printStackTrace();
                return "false";
            }
        }
        return "true";
    }

    @RequestMapping("/bookImageGet")
    public void getImage(String path, HttpServletRequest req,HttpServletResponse response) {
        FileInputStream fis = null;
        response.setContentType("image/gif");
        if(path==null){
            return;
        }
        try {
            String realPath = req.getServletContext().getRealPath("/WEB-INF/bookImage/"+path.replace("$","/"));
            System.out.println(realPath);
            OutputStream out = response.getOutputStream();
            File file = new File(realPath);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @ResponseBody
    @RequestMapping("/searchBook")
    public List<Book> searchBook(@RequestBody BookSelectParam bookSelectParam){

        bookSelectParam.setLimitCount(6);
        System.out.println(bookSelectParam);
        System.out.println(bookService.selectBook(bookSelectParam));
        return bookService.selectBook(bookSelectParam);
    }

    @RequestMapping("/multifile")
    public void upload(MultipartFile[] files , int uid, HttpServletRequest req) throws Exception{
        System.out.println(uid);
        System.out.println(files[0].getName());
        System.out.println(files[1].getName());
        System.out.println(files[2].getName());
        System.out.println(files[3].getName());


        // 判断文件是否为空，空则返回失败页面
        if (files.length==0) {
            return ;
        }
        for(MultipartFile file:files) {
            // 获取文件存储路径（绝对路径）
            String path = req.getServletContext().getRealPath("/WEB-INF/file");
            // 获取原文件名
            String fileName = file.getOriginalFilename();
            // 创建文件实例
            File filePath = new File(path, fileName);
            // 如果文件目录不存在，创建目录
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
                System.out.println("创建目录" + filePath);
            }
            // 写入文件
            file.transferTo(filePath);
        }
    }

    @ResponseBody
    @RequestMapping("/getBookByBid")
    public Book getBookByBid(int bid){
        System.out.println(bid);
        return bookService.selectBookByBid(bid);
    }
    @ResponseBody
    @RequestMapping("/updateBook")
    public int updateBook(Book book){
        return bookService.updateBook(book);
    }

}
