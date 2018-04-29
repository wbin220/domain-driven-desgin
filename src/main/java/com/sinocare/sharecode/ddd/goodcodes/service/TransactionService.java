package com.sinocare.sharecode.ddd.goodcodes.service;

import com.sinocare.sharecode.ddd.goodcodes.assembly.Assembly;
import com.sinocare.sharecode.ddd.goodcodes.domain.RefundDomain;
import com.sinocare.sharecode.ddd.goodcodes.domain.TransactionRecordDomain;
import com.sinocare.sharecode.ddd.goodcodes.domain.UserAccountDomain;
import com.sinocare.sharecode.ddd.goodcodes.domain.repository.RefundDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.domain.repository.TransactionRecordDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.domain.repository.UserAccountDomainRepository;
import com.sinocare.sharecode.ddd.goodcodes.model.entity.TransactionRecord;
import com.sinocare.sharecode.ddd.goodcodes.model.dto.TransactionRecordDTO;
import com.sinocare.sharecode.ddd.goodcodes.model.dto.UserAccountDTO;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.service
 * @author: bruce wu
 * @Date: 2017/12/15
 * @Time: 9:23
 * Description:
 */
public class TransactionService {

    private UserAccountDomainRepository userAccountDomainRepositoty=new UserAccountDomainRepository();


    private TransactionRecordDomainRepository transactionDomainRepositoty=new TransactionRecordDomainRepository();

    private RefundDomainRepository refundDomainRepository=new RefundDomainRepository();

    /**
     * 获取账户
     * @param accountCardNo
     * @return
     */
    public UserAccountDTO getUserAccount(String accountCardNo){
        UserAccountDTO userAccountDTO=Assembly.assembly(userAccountDomainRepositoty.getUserAccountDomain(accountCardNo),UserAccountDTO.class);
        return userAccountDTO;
    }

    /**
     * 交易
     * @param fromAccountCardNo
     * @param toAccountCardNo
     * @param transAmount
     * @return
     */
    public TransactionRecordDTO transfer(String fromAccountCardNo, String toAccountCardNo, double transAmount){
        UserAccountDomain fromDomain=userAccountDomainRepositoty.getUserAccountDomain(fromAccountCardNo);
        fromDomain.turnOut(transAmount);
        UserAccountDomain toDomain=userAccountDomainRepositoty.getUserAccountDomain(toAccountCardNo);
        toDomain.inCome(transAmount);
        TransactionRecordDomain recordDomain=transactionDomainRepositoty.createTranctionDomain(fromAccountCardNo,toAccountCardNo,transAmount);
        transactionDomainRepositoty.modifyTransactionRecord(Assembly.assembly(recordDomain, TransactionRecord.class));
        return Assembly.assembly(recordDomain,TransactionRecordDTO.class);
    }

    /**
     * 退款
     * @param transferId
     * @return
     */
    public TransactionRecordDTO refund(long transferId){
        if(transferId<=0){
            throw new RuntimeException("【refund faild】 transferId: "+transferId);
        }
        RefundDomain domain=refundDomainRepository.createRefundDomain(transferId);
        boolean refundResult=domain.refund();
        return Assembly.assembly(domain.getRefundRecord(),TransactionRecordDTO.class);
    }



}