package com.nove.shbtp.service;

import com.nove.shbtp.dao.UserAccountDao;
import com.nove.shbtp.dao.UserDao;
import com.nove.shbtp.pojo.User;
import com.nove.shbtp.pojo.UserAccount;
import com.nove.shbtp.utils.ShaUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.security.provider.SHA;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserAccountDao userAccountDao;

    public User loginByUsername(String username,String password){
        if(username!=null||password!=null){
            User user = userDao.selectUserByUsernamePrecise(username);
            if(user!=null){
                UserAccount userAccount = userAccountDao.selectUserAccountByUid(user.getUid());
                if(userAccount!=null&&userAccount.getPassword()!=null){
                    if(userAccount.getPassword().equals(ShaUtil.getSha256(password+user.getCreate_time())))
                        return user;
                }
            }
        }
        return null;
    }


    public User loginByPhoneNumber(String phoneNumber,String password){
        if(phoneNumber!=null||password!=null){
            User user = userDao.selectUserByPhoneNumber(phoneNumber);
            if(user!=null){
                UserAccount userAccount = userAccountDao.selectUserAccountByUid(user.getUid());
                if(userAccount!=null&&userAccount.getPassword()!=null){
                    if(userAccount.getPassword().equals(ShaUtil.getSha256(password+user.getCreate_time())))
                        return user;
                }
            }
        }
        return null;
    }
    public User loginByEmail(String email,String password){
        if(email!=null||password!=null){
            User user = userDao.selectUserByEmail(email);
            if(user!=null){
                UserAccount userAccount = userAccountDao.selectUserAccountByUid(user.getUid());
                if(userAccount!=null&&userAccount.getPassword()!=null){
                    if(userAccount.getPassword().equals(ShaUtil.getSha256(password+user.getCreate_time().trim())))
                        return user;
                }
            }
        }
        return null;
    }



    @Transactional(rollbackFor = {Exception.class})
    public User register(String phone_number,String password){
        if(phone_number!=null&&password!=null){
            try {
                User user = new User();
                user.setUser_name("User"+phone_number);
                user.setPhone_number(phone_number);
                userDao.addUser(user);
                user = userDao.selectUserByUid(user.getUid());
                UserAccount userAccount = new UserAccount();
                userAccount.setUid(user.getUid());
                userAccount.setPassword(ShaUtil.getSha256(password+user.getCreate_time()));
                userAccountDao.addUserAccount(userAccount);
                return user;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("事务回滚");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;

            }
        }
        return null;
    }

    public User checkPhone(String phone_number){
        User user = userDao.selectUserByPhoneNumber(phone_number);
        return user;
    }

//    检查是否存在用户名 存在返回true
    public User checkUsername(String username){
        User user = userDao.selectUserByUsernamePrecise(username);
        return user;
    }

    public User updateUser(User user){
        if(user!=null&&user.getUid()!=0) {
            int n = userDao.updateUser(user);
            if(n>0){
                return userDao.selectUserByUid(user.getUid());
            }
        }
        return null;
    }

    public String getUserFaceName(int uid){
        if(uid!=0){
            User user = userDao.selectUserByUid(uid);
            if(user!=null){
                return user.getFace();
            }
        }
        return null;
    }

    public String getUserName(int uid){
        if(uid!=0){
            User user = userDao.selectUserByUid(uid);
            if(user!=null){
                return user.getUser_name();
            }
        }
        return null;
    }
    public User getUser(int uid){

        return userDao.selectUserByUid(uid);
    }
}
