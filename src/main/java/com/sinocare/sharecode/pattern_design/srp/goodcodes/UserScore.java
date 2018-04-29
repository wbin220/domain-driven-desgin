package com.sinocare.sharecode.pattern_design.srp.goodcodes;

import com.sinocare.sharecode.pattern_design.srp.goodcodes.rules.AddScoreRuleStragey;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.pattern_design.srp.badcodes
 * @author:
 * @Date: 2017/12/11
 * @Time: 16:02
 * Description:加积分
 */
public class UserScore {

    /**调用积分场景策略*/
    private AddScoreRuleStragey ruleStragey;

    public UserScore(AddScoreRuleStragey ruleStragey){
        this.ruleStragey=ruleStragey;
    }


    public boolean addScore(String userCode,ScoreRuleSecene addSecene){
        boolean verifyResult=ruleStragey.verify(userCode,addSecene);
        if(verifyResult){
            System.out.println(addSecene.ruleName+"【累加积分】 userCode:"
                    +userCode+" addScore:"+addSecene.addScore);
        }
        return true;
    }
}