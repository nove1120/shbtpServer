package com.nove.shbtp.controller;


import com.nove.shbtp.pojo.UserAddress;
import com.nove.shbtp.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserAddressController {

    @Autowired
    UserAddressService userAddressService;


    @ResponseBody
    @RequestMapping("/uploadUserAddress")
    public UserAddress uploadUserAddress(@RequestBody UserAddress userAddress){
        System.out.println(userAddress);
        return userAddressService.addOrUpdateUserAddress(userAddress);
    }

    @ResponseBody
    @RequestMapping("/deleteUserAddress")
    public int deleteUserAddress(int address_id){
        return userAddressService.deleteAddress(address_id);
    }

    @ResponseBody
    @RequestMapping("/getUserAddress")
    public List<UserAddress> getUserAddress(int uid){
        return userAddressService.getUserAddressList(uid);
    }

    @ResponseBody
    @RequestMapping("/getUserDefaultAddress")
    public UserAddress getUserDefaultAddress(int uid){
        return userAddressService.getDefaultUserAddressList(uid);
    }
}
