package com.nove.shbtp.dao;

import com.nove.shbtp.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserDao {


    int addUser(User user);
    User selectUserByUid(Integer uid);
    User selectUserByUsernamePrecise(String user_name);
    List<User> selectUserByUsernameFuzzy(String user_name);
    User selectUserByPhoneNumber(String phone_number);
    User selectUserByEmail(String Email);
    List<User> selectAllUser();
    int updateUser(User user);
    int deleteUser(int uid);
}
