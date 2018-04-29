package com.sinocare.sharecode.ddd.goodcodes.domain;

import com.sinocare.sharecode.ddd.goodcodes.domain.repository.TransactionRecordDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.domain.repository.UserAccountDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.TransactionRecord;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.domain.repository
 * @author: bruce wu
 * @Date: 2017/12/15
 * @Time: 11:13
 * Description:
 */
public class RefundDomain {

    private long transferId;

    private TransactionRecord refundRecord;

    private UserAccountDomainRepository userAccountDomainRepositoty;

    private TransactionRecordDomainRepository transactionDomainRepositoty;

    public RefundDomain(long transferId,UserAccountDomainRepository userAccountDomainRepositoty,TransactionRecordDomainRepository transactionDomainRepositoty){
        this.transferId=transferId;
        this.userAccountDomainRepositoty=userAccountDomainRepositoty;
        this.transactionDomainRepositoty=transactionDomainRepositoty;
    }


    public boolean refund(){
        if(transferId<=0 ){
            throw new RuntimeException("【refund faild】 transferId: "+transferId);
        }
        refundRecord=transactionDomainRepositoty.getTransactionRecord(transferId);
        if(refundRecord==null){
            throw new RuntimeException("【refund faild】no transaction record ,transferId: "+transferId);
        }
        if(refundRecord.getTransStatus()!=1){
            throw new RuntimeException("【refund faild】 transaction record was refunded,transferId: "+transferId);
        }
        double refundAmount=refundRecord.getTransAmount();
        String fromAccountCardNo=refundRecord.getToAccount();
        String toAccountCardNo=refundRecord.getFromAccount();

        UserAccountDomain toAccountDomain=userAccountDomainRepositoty.getUserAccountDomain(toAccountCardNo);
        toAccountDomain.inCome(refundAmount);

        UserAccountDomain fromAccountDomain=userAccountDomainRepositoty.getUserAccountDomain(fromAccountCardNo);
        fromAccountDomain.turnOut(refundAmount);

        refundRecord.setTransStatus(2);
        refundRecord.setRefundTime(System.currentTimeMillis());
        transactionDomainRepositoty.modifyTransactionRecord(refundRecord);
        return true;
    }

    public TransactionRecord getRefundRecord() {
        return refundRecord;
    }

    public void setRefundRecord(TransactionRecord refundRecord) {
        this.refundRecord = refundRecord;
    }
}