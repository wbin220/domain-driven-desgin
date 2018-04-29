package com.sinocare.sharecode.ddd.goodcodes.domain;

import com.sinocare.sharecode.ddd.goodcodes.model.entity.TransactionRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.domain
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 15:59
 * Description:交易记录领域
 */
public class TransactionRecordDomain extends TransactionRecord {

        public void init(String fromAccountCardNo, String toAccountCardNo, double transAmount){
            this.setFromAccount(fromAccountCardNo);
            this.setToAccount(toAccountCardNo);
            this.setId(System.currentTimeMillis());
            this.setTransAmount(transAmount);
            this.setTransStatus(1);
            this.setTransTime(System.currentTimeMillis());
        }

}