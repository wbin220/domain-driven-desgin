package com.sinocare.sharecode.ddd.goodcodes.model.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.model
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 15:56
 * Description:账户
 */
public class UserAccount implements Serializable {


    protected static final long serialVersionUID = 1L;


    /**账户卡号*/
    private String accountCardNo;

    /**账户余额*/
    private double accountBalance;

    public String getAccountCardNo() {
        return accountCardNo;
    }

    public void setAccountCardNo(String accountCardNo) {
        this.accountCardNo = accountCardNo;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "accountCardNo='" + accountCardNo + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}