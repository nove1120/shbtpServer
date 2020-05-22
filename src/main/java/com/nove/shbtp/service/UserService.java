package com.nove.shbtp.service;

import com.nove.shbtp.pojo.User;

public interface UserService {

    public User loginByUsername(String username,String password);
    public User loginByPhoneNumber(String phoneNumber,String password);
    public User loginByEmail(String email,String password);
    public User register(String phone_number,String password);
    public User checkPhone(String phone_number);
    public User checkUsername(String username);
    public User updateUser(User user);
    public String getUserFaceName(int uid);
    public String getUserName(int uid);
    public User getUser(int uid);
}
