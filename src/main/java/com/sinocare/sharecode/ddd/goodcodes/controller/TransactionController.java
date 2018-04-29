package com.sinocare.sharecode.ddd.goodcodes.controller;


import com.sinocare.sharecode.ddd.goodcodes.model.dto.TransactionRecordDTO;
import com.sinocare.sharecode.ddd.goodcodes.service.TransactionService;

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


    public TransactionRecordDTO transfer(String fromAccountCardNo, String toAccountCardNo, double transAmount){
        return transactionService.transfer(fromAccountCardNo,toAccountCardNo,transAmount);
    }

    public TransactionRecordDTO refund(long recordId){
        return  transactionService.refund(recordId);
    }

    public static void main(String[] args) {
        String fromAccountCardNo="AAAA";
        String toAccountCardNo="BBBB";
        double transAmount=1;
        System.out.println("【........转账开始....】");
        TransactionController controller=new TransactionController();
        System.out.println("交易前："+controller.getTransactionService().getUserAccount(fromAccountCardNo));
        System.out.println("交易前："+controller.getTransactionService().getUserAccount(toAccountCardNo));

        TransactionRecordDTO record=controller.transfer(fromAccountCardNo,toAccountCardNo,transAmount);
        System.out.println("【转账成功，交易记录：】"+record);
        System.out.println("【交易后：】"+controller.getTransactionService().getUserAccount(fromAccountCardNo));
        System.out.println("【交易后：】"+controller.getTransactionService().getUserAccount(toAccountCardNo));
        System.out.println("--------------------------");
        System.out.println("【........退款开始....】");
        TransactionRecordDTO refundRecord=controller.refund(record.getId());
        System.out.println("【退款成功，交易记录：】"+refundRecord);
        System.out.println("【退款交易后：】"+controller.getTransactionService().getUserAccount(fromAccountCardNo));
        System.out.println("【退款交易后：】"+controller.getTransactionService().getUserAccount(toAccountCardNo));

        /**多次退款肯定失败*/
//        controller.refund(refundRecord.getId());
//        System.out.println("退款成功，交易记录："+refundRecord);
//        System.out.println(controller.getTransactionService().getUserAccount(fromAccountCardNo));
//        System.out.println(controller.getTransactionService().getUserAccount(toAccountCardNo));

    }
}