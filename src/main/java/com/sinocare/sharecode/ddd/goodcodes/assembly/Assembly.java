package com.sinocare.sharecode.ddd.goodcodes.assembly;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package:com.sinocare.sharecode.ddd.goodcodes.service.assembly
 * @author: bruce wu
 * @Date: 2017/12/15
 * @Time: 9:26
 * Description:简单对象装配器
 */
public abstract class Assembly {


    /**
     * 复制单独对象（利用apache BeanUtils）
     * @param sourceObj
     * @param targetClass
     * @return
     * @author jerry
     */
    public static <S, T> T assembly(S sourceObj, Class<T> targetClass) {
        try {
            T t = targetClass.newInstance();
            BeanUtils.copyProperties(t,sourceObj);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}