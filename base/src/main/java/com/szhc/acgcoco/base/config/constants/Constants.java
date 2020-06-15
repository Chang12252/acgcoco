package com.szhc.acgcoco.base.config.constants;

public enum Constants {

    /*正常状态*/YES("yes"),
    /*删除|异常状态*/NO("no"),
    /*QQ*/QQ("qq"),
    /*微信*/WEIXIN("weixin"),
    /*验证码后缀*/CAPTCHA("captcha"),
    /*男默认头像*/HEAD("head"),
    /*默认微信号*/WX("wx"),
    /*课程顾问二维码*/QRCODE("qrcode"),
    /*登录页背景图*/LOGINBANNER("loginbanner"),
    /*订单状态*/
    /*未付款*/NOTPAY("notpay"),
    /*拼单中，已支付*/SPELL("spell"),
    /*上课中*/ATTEND("attend"),
    /*已完成*/COMPLETE("complete"),
    /*已取消*/CANCEL("cancel");


    Constants(String value) {
        this.value = value;
    }
    private String value;

    public String getValue() {
        return value;
    }

}
