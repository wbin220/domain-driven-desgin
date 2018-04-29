package com.sinocare.sharecode.pattern_design.srp.goodcodes;

/**
 * Created with IntelliJ IDEA.
 * User:
 * Date: 2017/12/12
 * Time: 9:20
 * Description:积分场景定义
 */
public enum ScoreRuleSecene {

        SELF_REGISTER("手机注册",20),
        FRIEND_INVITE_REGISTER("好友邀请",30);

        public String ruleName;
        public int addScore;
        public boolean isExp;

        ScoreRuleSecene(String ruleName, int addScore,boolean...isExp){
            this.ruleName=ruleName;
            this.addScore=addScore;
            if(isExp!=null && isExp.length>0){
                this.isExp=isExp[0];
            }
        }
}