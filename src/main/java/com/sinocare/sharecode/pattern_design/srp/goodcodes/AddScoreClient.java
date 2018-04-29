package com.sinocare.sharecode.pattern_design.srp.goodcodes;

import com.sinocare.sharecode.pattern_design.srp.goodcodes.rules.InviteRegisterRuleStragey;
import com.sinocare.sharecode.pattern_design.srp.goodcodes.rules.SelfRegisterRuleStragey;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.pattern_design.srp.badcodes
 * @author:
 * @Date: 2017/12/11
 * @Time: 16:12
 * Description:
 */
public class AddScoreClient {

    public static void main(String[] args) {
        UserScore selfStrageyAdder = new UserScore(new SelfRegisterRuleStragey());
        selfStrageyAdder.addScore("张三丰", ScoreRuleSecene.SELF_REGISTER);
        UserScore inviteStrageyAdder = new UserScore(new InviteRegisterRuleStragey());
        inviteStrageyAdder.addScore("张三丰", ScoreRuleSecene.FRIEND_INVITE_REGISTER);
    }
}