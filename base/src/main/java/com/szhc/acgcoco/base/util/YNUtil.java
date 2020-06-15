package com.szhc.acgcoco.base.util;

import org.springframework.util.StringUtils;

/**
 * @author HgJava
 * @description yes/no转为是/否
 * @date 2020/5/15
 */
public class YNUtil {

    public static String ynConvert(String value){
        if(value.equals("yes")){
            return "是";
        }else{
            return "否";
        }
    }

    //订单状态（未付款notpay、拼单中spell、上课中attend、已完成complete、已取消cancel）
    public static String orderStatusConvert(String status){
        if(!StringUtils.isEmpty(status)){
            if(status.equals("notpay")){
                 return "未付款";
            }else if(status.equals("spell")){
                 return "拼单中";
            }else if(status.equals("complete")){
                 return "已完成";
            }else if(status.equals("cancel")){
                return "已取消";
            }
        }
        return "";
    }

}
