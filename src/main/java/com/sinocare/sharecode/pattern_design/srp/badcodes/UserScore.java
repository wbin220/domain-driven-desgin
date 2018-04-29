package com.sinocare.sharecode.pattern_design.srp.badcodes;

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


    public boolean addScore(int addSecene, String userCode){
        int addScore=0;
        if(addSecene==1){
            /**自己注册app场景*/
            addScore=20;
        }else if(addSecene==2){
            /**好友邀请场景*/
            addScore=30;
        }
        System.out.println((addSecene==1?"注册":"好友邀请")+"【累加积分】 userCode:"
                +userCode+" addScore:"+addScore);
        return true;
    }
}