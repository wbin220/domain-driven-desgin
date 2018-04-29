package com.sinocare.sharecode.pattern_design.srp.badcodes;

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
        UserScore us=new UserScore();
        us.addScore(1,"张三丰");
        us.addScore(2,"张三丰");
    }
}