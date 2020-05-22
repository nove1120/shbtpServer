package com.nove.shbtp.controller;

import com.nove.shbtp.dto.LoginParam;
import com.nove.shbtp.dto.RegisterParam;
import com.nove.shbtp.pojo.User;
import com.nove.shbtp.service.UserService;
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

@Controller
public class UserController {
    @Autowired
    UserService userService;

//    @RequestMapping("/login")
//    @ResponseBody
//    public String login(@RequestBody LoginParam loginParam){
//        LoginParam loginParam1 = new LoginParam();
//        if(loginParam.getUser_name()!=null&&loginParam.getPassword()!=null){
//            if(userService.login(loginParam.getUser_name(),loginParam.getPassword()))
//                return "true";
//        }
//        return "false";
//    }

    @ResponseBody
    @RequestMapping("/loginAccount")
    public User loginAccount(@RequestBody LoginParam loginParam){
        User user=null;
        System.out.println(loginParam);
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if(account!=null&&password!=null) {
            if (loginParam.getAccountType() == LoginParam.AccountType.USER_NAME) {
                user = userService.loginByUsername(account,password);
            } else if (loginParam.getAccountType() == LoginParam.AccountType.PHONE_NUMBER) {
                user = userService.loginByPhoneNumber(account,password);
            } else if (loginParam.getAccountType() == LoginParam.AccountType.EMAIL) {
                user = userService.loginByEmail(account,password);
            }
        }
        System.out.println(user);
        return user;
    }


    @ResponseBody
    @RequestMapping("/loginSMS")
    public User loginSMS(String phone_number){
        User user = userService.checkPhone(phone_number);
        return user;
    }
    @ResponseBody
    @RequestMapping("/register")
    public User register(@RequestBody  RegisterParam registerParam){
        String phoneNumber = registerParam.getPhoneNumber();
        String password = registerParam.getPassword();
        System.out.println(registerParam);
        return userService.register(phoneNumber,password);
    }

    @ResponseBody
    @RequestMapping("/userFaceUpload")
    public String bookImageUpload(MultipartFile file , int uid, HttpServletRequest req){


        // 判断文件是否为空，空则返回失败页面
        if (uid==0||file==null) {
            return "false";
        }

        // 获取文件存储路径（绝对路径）
        String path = "D:\\shbtpFile\\userImage\\"+uid;
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

        return "true";
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public  User updateUser(@RequestBody User user){
        System.out.println(user);
        return  userService.updateUser(user);
    }


    @ResponseBody
    @RequestMapping("/checkUserName")
    public  String checkUserName(String userName){
        User user =  userService.checkUsername(userName);
        if(user!=null){
            return "true";
        }else{
            return "false";
        }
    }

    @RequestMapping("/getUserFace")
    public void getUserFaceImageName(int uid, HttpServletRequest req, HttpServletResponse response) {

        System.out.println(uid);
        String faceName = userService.getUserFaceName(uid);
        if(faceName!=null&&faceName.length()!=0){
            FileInputStream fis = null;
            response.setContentType("image/gif");
            try {
                String realPath = "D:\\shbtpFile\\userImage\\"+uid+"\\"+faceName;
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
    }

    @ResponseBody
    @RequestMapping("/getUserName")
    public  String checkUserName(int uid){
        System.out.println(userService.getUserName(uid));
        return userService.getUserName(uid);
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public  User checkUser(int uid){
        System.out.println(userService.getUserName(uid));
        return userService.getUser(uid);
    }
}
