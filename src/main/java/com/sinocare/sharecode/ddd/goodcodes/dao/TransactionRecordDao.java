package com.sinocare.sharecode.ddd.goodcodes.dao;

import com.sinocare.sharecode.ddd.goodcodes.model.entity.TransactionRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.badcodes.dao
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 16:09
 * Description:
 */
public class TransactionRecordDao {

    private static Map<Long,TransactionRecord> localCache=new HashMap<Long,TransactionRecord>();


    public boolean insertOrModifyTransactionRecord(TransactionRecord record){
        localCache.put(record.getId(),record);
        return true;
    }

    public TransactionRecord getTransactionRecord(long recordId){
        return localCache.get(recordId);
    }
}