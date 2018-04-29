package com.sinocare.sharecode.pattern_design.srp.goodcodes.rules;

import com.sinocare.sharecode.pattern_design.srp.goodcodes.ScoreRuleSecene;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.pattern_design.srp.goodcodes
 * @author:
 * @Date: 2017/12/12
 * @Time: 9:17
 * Description:积分规则策略
 */
public abstract class AddScoreRuleStragey {

    /***
     * 抽象通用策略
     * @param userCode
     * @param scoreRuleSecene
     * @return
     */
    public boolean verify(String userCode,ScoreRuleSecene scoreRuleSecene){
        /**是否已领取*/
        boolean isTaked=false;
        if(isTaked){
            throw  new RuntimeException("已领改积分"+scoreRuleSecene);
        }
        /**场景是否已过期*/
        boolean isExp=scoreRuleSecene.isExp;
        if(isExp){
            throw  new RuntimeException("积分场景已失效"+scoreRuleSecene);
        }
        return true;
    }

    /**
     * 加积分后的策略
     * @param userCode
     * @param scoreRuleSecene
     * @return
     */
    public abstract boolean doAfterAddScore(String userCode,ScoreRuleSecene scoreRuleSecene);
}