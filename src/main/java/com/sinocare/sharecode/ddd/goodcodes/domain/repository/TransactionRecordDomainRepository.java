package com.sinocare.sharecode.ddd.goodcodes.domain.repository;

import com.sinocare.sharecode.ddd.goodcodes.dao.TransactionRecordDao;
import com.sinocare.sharecode.ddd.goodcodes.domain.TransactionRecordDomain;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.TransactionRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.domain.repository
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 17:26
 * Description:交易记录仓储
 */
public class TransactionRecordDomainRepository {

    private TransactionRecordDao dao=new TransactionRecordDao();

    public TransactionRecordDomain createTranctionDomain(String fromAccountCardNo, String toAccountCardNo, double transAmount){
        TransactionRecordDomain domian=new TransactionRecordDomain();
        domian.init(fromAccountCardNo,toAccountCardNo,transAmount);
        return domian;
    }

    public boolean modifyTransactionRecord(TransactionRecord record){
        return dao.insertOrModifyTransactionRecord(record);
    }

    public TransactionRecord getTransactionRecord(long recordId){
        return dao.getTransactionRecord(recordId);
    }


}