package com.nove.shbtp.controller;

import com.nove.shbtp.dao.*;
import com.nove.shbtp.pojo.*;
import com.nove.shbtp.utils.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;

@Controller
public class testController {

    @RequestMapping("/t")
    public String t(){
        System.out.println("t");
        return "/WEB-INF/pages/s1.jsp";
    }

    @ResponseBody
    @RequestMapping("/ajaxServlet")
    public String ajaxServlet(String username){
        System.out.println(username);

        return "asdad";
    }

//    @ResponseBody
//    @RequestMapping("/ajaxServlet")
//    public TestClass ajaxServlet(TestClass testClass, HttpServletResponse response){
//        System.out.println(testClass);
//
//        return new TestClass();
//    }
//    class TestClass{
//        String a;
//        int b;
//        TestClass(){
//
//        };
//        TestClass(String a,int b){
//            this.a=a;
//            this.b=b;
//        }
//
//        @Override
//        public String toString() {
//            return a+b;
//        }
//    }


    @RequestMapping("/test")
    public String test(@RequestBody String pwd) {
//        System.out.println(pwd);
        try {

            String hashed = URLDecoder.decode(pwd, "UTF-8");
//            System.out.println(decoderUrl);
            String candidate = "testpassword";
//            String hashed = BCrypt.hashpw(candidate,BCrypt.gensalt());
            System.out.println(hashed);
            BCrypt.gensalt();
            //String candidate = "wrongtestpassword";
            if (BCrypt.checkpw(candidate, hashed))
                System.out.println("It matches");
            else
                System.out.println("It does not match");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "s1";
    }

    @Autowired
    private UserAccountDao userAccountDao;
    @RequestMapping("/testmybatis")
    public void testmybatis(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUid(3);
        userAccount.setPassword("234");
//        userAccountDao.addUserAccount(userAccount);
//        System.out.println(userAccountDao.selectAllUserAccount());
//        userAccount = userAccountDao.selectUserAccountByUid(3);
        System.out.println(userAccountDao.selectUserAccountByUid(3));
//        userAccount.setPassword("789");
//        userAccountDao.updateUserAccount(userAccount);
//        System.out.println(userAccountDao.selectAllUserAccount());
//        userAccountDao.deleteUserAccount(3);
//        System.out.println(userAccountDao.selectAllUserAccount());
    }
//    @Autowired
//    UserDao userDao;
//    @Autowired
//    UserService userService;


    @Autowired
    BookOrderDao bookOrderDao;
    @RequestMapping("/t2")
    public void userTest(){
//        BookOrder bookOrder = new BookOrder();
//        bookOrder.setBid(1);
//        bookOrder.setSell_uid(1);
//        bookOrder.setBuy_uid(1);
//        bookOrder.setConsignee("adsad");
//        bookOrder.setLocation("dadadw");
//        bookOrder.setAddress("dscecew");
//        bookOrder.setPhone_number("121212");
//
//        bookOrderDao.addBookOrder(bookOrder);
//        System.out.println(bookOrderDao.selectBookOrderByBuyUid(1));
//        System.out.println(bookOrderDao.selectBookOrderBySellUid(1));

    }
    @Autowired
    BookDao bookDao;
    @RequestMapping("/booktest")
    @ResponseBody
    public void jsontset(){
        System.out.println(bookDao.selectUpdateTime(41));

    }
    @RequestMapping(value = "/image/get")
    public void getImage(HttpServletRequest request, HttpServletResponse response) {
        FileInputStream fis = null;
        response.setContentType("image/gif");
        try {
            OutputStream out = response.getOutputStream();
            File file = new File("D:"+File.separator+"test.jpg");
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


}