package com.sinocare.sharecode.ddd.goodcodes.domain.repository;

import com.sinocare.sharecode.ddd.goodcodes.domain.RefundDomain;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.domain.repository
 * @author: bruce wu
 * @Date: 2017/12/15
 * @Time: 11:19
 * Description:退款领域仓储
 */
public class RefundDomainRepository {

    private UserAccountDomainRepository userAccountDomainRepositoty=new UserAccountDomainRepository();

    private TransactionRecordDomainRepository transactionDomainRepositoty=new TransactionRecordDomainRepository();

    public RefundDomain createRefundDomain(long transferId){
       return new RefundDomain(transferId,userAccountDomainRepositoty,transactionDomainRepositoty);
    }
}