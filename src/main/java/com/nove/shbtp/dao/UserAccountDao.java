package com.nove.shbtp.dao;

import com.nove.shbtp.pojo.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserAccountDao {

    public Integer addUserAccount(UserAccount userAccount);

    public UserAccount selectUserAccountByUid(Integer uid);

    public List<UserAccount> selectAllUserAccount();

    public Integer updateUserAccount(UserAccount userAccount);

    public Integer deleteUserAccount(Integer uid);
}
