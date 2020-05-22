package com.nove.shbtp.service;

import com.nove.shbtp.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {
    public UserAddress addOrUpdateUserAddress(UserAddress userAddress);
    public int deleteAddress(int address_id);
    public List<UserAddress> getUserAddressList(int uid);
    public UserAddress getDefaultUserAddressList(int uid);
}
