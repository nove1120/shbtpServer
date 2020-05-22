package com.nove.shbtp.dao;

import com.nove.shbtp.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserAddressDao {

    int addAddress(UserAddress address);
    UserAddress selectAddressByAddressId(int address_id);
    List<UserAddress> selectAddressByUid(int uid);
    UserAddress selectDefaultAddressByUid(int uid);
    int updateAddress(UserAddress address);
    int deleteAddress(int Address_id);

}
