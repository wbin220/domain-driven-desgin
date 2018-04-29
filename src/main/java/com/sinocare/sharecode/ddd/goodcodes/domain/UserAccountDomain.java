package com.sinocare.sharecode.ddd.goodcodes.domain;

import com.sinocare.sharecode.ddd.goodcodes.assembly.Assembly;
import com.sinocare.sharecode.ddd.goodcodes.domain.repository.UserAccountDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.UserAccount;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.model
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 15:56
 * Description:用户账户领域
 */
public class UserAccountDomain extends UserAccount {

    private UserAccountDomainRepository userAccountDomainRepositoty;

    public UserAccountDomainRepository getUserAccountDomainRepositoty() {
        return userAccountDomainRepositoty;
    }

    public void setUserAccountDomainRepositoty(UserAccountDomainRepository userAccountDomainRepositoty) {
        this.userAccountDomainRepositoty = userAccountDomainRepositoty;
    }

    /**
     * 转出逻辑
     * @param amount 操作金额
     * @return
     */
    public boolean turnOut(double amount){
        if(this.getAccountBalance()<amount){
            throw  new RuntimeException("【turnOut fail】 "+this.getAccountCardNo()+" balance is not enough ");
        }
        this.setAccountBalance(this.getAccountBalance()-amount);
        UserAccount account= Assembly.assembly(this,UserAccount.class);
        this.userAccountDomainRepositoty.modifyUserAccount(account);
        return true;
    }

    /**
     * 转入逻辑
     * @param amount 操作金额
     * @return
     */
    public boolean inCome(double amount){
        this.setAccountBalance(this.getAccountBalance()+amount);
        UserAccount account= Assembly.assembly(this,UserAccount.class);
        this.userAccountDomainRepositoty.modifyUserAccount(account);
        return true;
    }

}