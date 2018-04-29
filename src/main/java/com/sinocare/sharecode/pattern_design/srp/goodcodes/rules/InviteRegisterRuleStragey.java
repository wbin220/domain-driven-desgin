package com.sinocare.sharecode.pattern_design.srp.goodcodes.rules;

import com.sinocare.sharecode.pattern_design.srp.goodcodes.ScoreRuleSecene;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.pattern_design.srp.goodcodes.rules
 * @author:
 * @Date: 2017/12/12
 * @Time: 10:03
 * Description:
 */
public class InviteRegisterRuleStragey extends  AddScoreRuleStragey {

    @Override
    public boolean verify(String userCode,ScoreRuleSecene scoreRuleSecene){
        super.verify(userCode,scoreRuleSecene);
        String friendUserCode="灭绝师太";
        boolean isAddFriended=true;
        if(isAddFriended){
            throw  new RuntimeException(friendUserCode+"已经是您的好友，不能再获得相应的积分");
        }
        return true;
    }

    /**
     * 加积分后的策略
     *
     * @param userCode
     * @param scoreRuleSecene
     * @return
     */
    public boolean doAfterAddScore(String userCode, ScoreRuleSecene scoreRuleSecene) {
        String friendUserCode="灭绝师太";
        System.out.println("【微信模板消息】恭喜灭绝师太，"+userCode+"成为您的好友，同时您也获得了"+scoreRuleSecene.addScore+"积分");
        return true;
    }
}