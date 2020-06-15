package com.szhc.acgcoco.base.config.constants;

import java.util.HashMap;
import java.util.Map;

public class ResponseMsg {
    public static Map<String,String> msg;
    static {
        msg=new HashMap<>();
        //00开头标识公用
        msg.put("00000","成功");
        msg.put("00001","参数异常");
        msg.put("00002","用户未登录");
        msg.put("00003","发生异常请稍后从试");
        msg.put("00004","请联系管理员绑定公司信息");

        //01开头系统用户相关
        msg.put("01000","密码错误");
        msg.put("01001","账号已存在");
        msg.put("01002","用户不存在");
        msg.put("01003","密码不能与之前一样");
        msg.put("01004","该角色已存在");
        msg.put("01005","该角色下存在用户");

        //02开头用户相关
        msg.put("02000","手机号码格式错误");
        msg.put("02001","验证码过期");
        msg.put("02002","验证码错误");
        msg.put("02003","账号异常");
        msg.put("02004","未绑定手机");
        msg.put("02005","用户不存在");
        msg.put("02006","密码错误");
        msg.put("02007","用户已存在");
        msg.put("02008","手机号已绑定账号");
        msg.put("02009","已确认不能操作");
        msg.put("02010","不能在此阶段添加");
        msg.put("02011","用户授权失败");
        msg.put("02012","用户手机号绑定失败");
        msg.put("02013","未绑定手机号");
        msg.put("02014","验证码不能为空");
        msg.put("02015","手机号不能为空");

        //03开头联系人相关
        msg.put("03000","未填写完家长信息");
        msg.put("03001","未绑定联系人");
        msg.put("03002","更新联系人状态失败");

        //04 地理位置相关
        msg.put("04000","地理位置未开放");


    }

}
