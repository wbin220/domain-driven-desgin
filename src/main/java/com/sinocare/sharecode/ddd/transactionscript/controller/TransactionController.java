package com.sinocare.sharecode.ddd.transactionscript.controller;

import com.sinocare.sharecode.ddd.transactionscript.model.TransactionRecord;
import com.sinocare.sharecode.ddd.transactionscript.service.TransactionService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.badcodes.controller
 * @author: bruce wu
 * @Date: 2017/12/14
 * @Time: 16:47
 * Description:模拟Controller控制器
 */
public class TransactionController {

    private TransactionService transactionService=new TransactionService();

    public TransactionService getTransactionService(){
        return transactionService;
    }


    public TransactionRecord transfer(String fromAccountCardNo, String toAccountCardNo, double transAmount){
        return transactionService.transfer(fromAccountCardNo,toAccountCardNo,transAmount);
    }

    public TransactionRecord refund(long recordId){
        return  transactionService.refund(recordId);
    }

    public static void main(String[] args) {
        String fromAccountCardNo="AAAA";
        String toAccountCardNo="BBBB";
        double transAmount=1;
        System.out.println("转账开始....");
        TransactionController controller=new TransactionController();
        TransactionRecord record=controller.transfer(fromAccountCardNo,toAccountCardNo,transAmount);
        System.out.println("交易成功，交易记录："+record);
        System.out.println(controller.getTransactionService().getUserAccount(fromAccountCardNo));
        System.out.println(controller.getTransactionService().getUserAccount(toAccountCardNo));

        System.out.println("退款开始....");
        TransactionRecord refundRecord=controller.refund(record.getId());
        System.out.println("退款成功，交易记录："+refundRecord);
        System.out.println(controller.getTransactionService().getUserAccount(fromAccountCardNo));
        System.out.println(controller.getTransactionService().getUserAccount(toAccountCardNo));

        /**多次退款肯定失败*/
//        controller.refund(refundRecord.getId());
//        System.out.println("退款成功，交易记录："+refundRecord);
//        System.out.println(controller.getTransactionService().getUserAccount(fromAccountCardNo));
//        System.out.println(controller.getTransactionService().getUserAccount(toAccountCardNo));

    }
}