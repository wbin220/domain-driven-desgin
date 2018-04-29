package com.sinocare.sharecode.ddd.transactionscript.service;

import com.sinocare.sharecode.ddd.transactionscript.dao.TransactionRecordDao;
import com.sinocare.sharecode.ddd.transactionscript.dao.UserAccountDao;
import com.sinocare.sharecode.ddd.transactionscript.model.TransactionRecord;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.UserAccount;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.badcodes.service
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 16:08
 * Description:
 */
public class TransactionService {

    private UserAccountDao userAccountDao=new UserAccountDao();

    private TransactionRecordDao transactionRecordDao=new TransactionRecordDao();

    /**
     * 获取账户
     * @param accountCardNo
     * @return
     */
    public UserAccount getUserAccount(String accountCardNo){
       return userAccountDao.getUserAccount(accountCardNo);
    }

    /**
     * 转账交易
     * @param fromAccountCardNo 转出账号
     * @param toAccountCardNo   转入账号
     * @param transAmount 交易金额
     * @return
     */
    public TransactionRecord transfer(String fromAccountCardNo, String toAccountCardNo,double transAmount){
        UserAccount fromAccount=getUserAccount(fromAccountCardNo);
        if(fromAccount.getAccountBalance()<transAmount){
            throw  new RuntimeException("【transfer faild】 account "+fromAccountCardNo+" of balance is not enough");
        }
        fromAccount.setAccountBalance(fromAccount.getAccountBalance()-transAmount);
        UserAccount toAccount=getUserAccount(toAccountCardNo);
        toAccount.setAccountBalance(toAccount.getAccountBalance()+transAmount);
        userAccountDao.modifyUserAccount(fromAccount);
        userAccountDao.modifyUserAccount(toAccount);

        TransactionRecord record=new TransactionRecord();
        record.setFromAccount(fromAccountCardNo);
        record.setToAccount(toAccountCardNo);
        record.setId(System.currentTimeMillis());
        record.setTransAmount(transAmount);
        record.setTransStatus(1);
        record.setTransTime(System.currentTimeMillis());
        boolean isSuc=transactionRecordDao.insertOrModifyTransactionRecord(record);
        if(isSuc){
            return record;
        }
        throw new RuntimeException("【transfer faild】 account :"+
                fromAccountCardNo+" toAccountCardNo:"+toAccountCardNo+" transAmount:"+transAmount);
    }

    /**
     * 退款(可以看到退款里面大部分业务代码分根转账代码类型，所以将账户变动的业务逻辑放入领域里面就能复用)
     * @param transferId
     * @return
     */
    public TransactionRecord refund(long transferId){
        TransactionRecord record=transactionRecordDao.getTransactionRecord(transferId);
        if(record==null){
            throw new RuntimeException("【refund faild】no transaction record ,transferId: "+transferId);
        }
        if(record.getTransStatus()!=1){
            throw new RuntimeException("【refund faild】 transaction record was refunded,transferId: "+transferId);
        }
        double refundAmount=record.getTransAmount();
        String toAccountCardNo=record.getFromAccount();
        String fromAccountCardNo=record.getToAccount();

        UserAccount fromAccount=getUserAccount(fromAccountCardNo);
        if(fromAccount.getAccountBalance()<refundAmount){
            throw  new RuntimeException("【refund faild】 account "+fromAccountCardNo+" of balance is not enough");
        }
        fromAccount.setAccountBalance(fromAccount.getAccountBalance()-refundAmount);
        UserAccount toAccount=getUserAccount(toAccountCardNo);
        toAccount.setAccountBalance(toAccount.getAccountBalance()+refundAmount);
        userAccountDao.modifyUserAccount(fromAccount);
        userAccountDao.modifyUserAccount(toAccount);
        record.setTransStatus(2);
        record.setRefundTime(System.currentTimeMillis());
        transactionRecordDao.insertOrModifyTransactionRecord(record);
        return record;
    }



}