package com.sinocare.sharecode.ddd.goodcodes.dao;

import com.sinocare.sharecode.ddd.goodcodes.model.entity.UserAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.badcodes.dao
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 16:08
 * Description:
 */
public class UserAccountDao {

    private static Map<String,UserAccount> userAccountLocalCache=new HashMap<String,UserAccount>();

    public UserAccount getUserAccount(String accountCardNo){
        UserAccount account=userAccountLocalCache.get(accountCardNo);
        if(account==null){
            account=new UserAccount();
            account.setAccountCardNo(accountCardNo);
            account.setAccountBalance(100);
            userAccountLocalCache.put(accountCardNo,account);
        }
        return account;
    }

    public boolean modifyUserAccount(UserAccount account){
        userAccountLocalCache.put(account.getAccountCardNo(),account);
        return true;
    }

}