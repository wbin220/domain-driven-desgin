package com.sinocare.sharecode.ddd.transactionscript.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.badcodes.model
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 15:59
 * Description:交易记录
 */
public class TransactionRecord implements Serializable{

    private static final long serialVersionUID = 1L;

    /**交易id*/
    private long id;

    /**转出账户*/
    private String fromAccount;

    /**转入账户*/
    private String toAccount;

    /**交易金额*/
    private double transAmount;

    /**交易时间*/
    private long transTime;

    /**退款时间*/
    private long refundTime;

    /**交易状态*/
    private int transStatus;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public long getTransTime() {
        return transTime;
    }

    public void setTransTime(long transTime) {
        this.transTime = transTime;
    }

    public int getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(int transStatus) {
        this.transStatus = transStatus;
    }

    public long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(long refundTime) {
        this.refundTime = refundTime;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "id=" + id +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", transAmount=" + transAmount +
                ", transTime=" + transTime +
                ", refundTime=" + refundTime +
                ", transStatus=" + transStatus +
                '}';
    }
}