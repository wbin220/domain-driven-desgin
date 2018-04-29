package com.sinocare.sharecode.ddd.goodcodes.domain.repository;

import com.sinocare.sharecode.ddd.goodcodes.assembly.Assembly;
import com.sinocare.sharecode.ddd.goodcodes.dao.UserAccountDao;
import com.sinocare.sharecode.ddd.goodcodes.domain.UserAccountDomain;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.UserAccount;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.domain.repository
 * @author:
 * @Date: 2017/12/14
 * @Time: 17:26
 * Description:用户账户仓储
 */
public class UserAccountDomainRepository {

    private UserAccountDao userAccountDao=new UserAccountDao();

    public UserAccountDomain getUserAccountDomain(String accountCardNo){
        UserAccount account= userAccountDao.getUserAccount(accountCardNo);
        UserAccountDomain domain= Assembly.assembly(account,UserAccountDomain.class);
        domain.setUserAccountDomainRepositoty(this);
        return domain;
    }

    public boolean modifyUserAccount(UserAccount account){
        return userAccountDao.modifyUserAccount(account);
    }


}