package com.nove.shbtp.service;

import com.nove.shbtp.dao.UserAccountDao;
import com.nove.shbtp.dao.UserAddressDao;
import com.nove.shbtp.dao.UserDao;
import com.nove.shbtp.pojo.User;
import com.nove.shbtp.pojo.UserAccount;
import com.nove.shbtp.pojo.UserAddress;
import com.nove.shbtp.utils.ShaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressDao userAddressDao;

    //通过传入userAddress参数是否设置address_id判断是添加还是修改
    public UserAddress addOrUpdateUserAddress(UserAddress userAddress){
        int address_id = userAddress.getAddress_id();
        if(userAddress.getUid()<=0){
            return  null;
        }
        if(userAddress.getDefault_flag()==1){
            UserAddress oldDefaultUserAddress = userAddressDao.selectDefaultAddressByUid(userAddress.getUid());
            if(oldDefaultUserAddress!=null) {
                oldDefaultUserAddress.setDefault_flag(0);
                userAddressDao.updateAddress(oldDefaultUserAddress);
            }
        }
        if(address_id>0){
            userAddressDao.updateAddress(userAddress);
            return userAddress;
        }else{
            userAddressDao.addAddress(userAddress);
            return userAddress;
        }
    }


    public int deleteAddress(int address_id){
        return userAddressDao.deleteAddress(address_id);
    }

    public List<UserAddress> getUserAddressList(int uid){
        return userAddressDao.selectAddressByUid(uid);
    }

    public UserAddress getDefaultUserAddressList(int uid){
        return userAddressDao.selectDefaultAddressByUid(uid);
    }

}
