package com.sinocare.sharecode.pattern_design.srp.goodcodes.rules;

import com.sinocare.sharecode.pattern_design.srp.goodcodes.ScoreRuleSecene;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.pattern_design.srp.goodcodes
 * @author:
 * @Date: 2017/12/12
 * @Time: 10:02
 * Description:
 */
public class SelfRegisterRuleStragey extends AddScoreRuleStragey{


    /**
     * 加积分后的策略
     *
     * @param userCode
     * @param scoreRuleSecene
     * @return
     */
    public boolean doAfterAddScore(String userCode, ScoreRuleSecene scoreRuleSecene) {
        return true;
    }
}