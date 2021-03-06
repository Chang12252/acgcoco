package com.szhc.acgcoco.base.util.wechat.config;


import com.szhc.acgcoco.base.util.wechat.WXPayUtil;
import java.util.HashMap;
import java.util.Map;

//微信配置信息类
public class WXConfig {
    //小程序appid
    public static String  APPID_JSAPI="wx52433520edbec90c";

    //public static String redirect_uri="http://8d4pkb.natappfree.cc";//回调域名测试
    public static String redirect_uri="http://hny.jointeam6.com/api";//回调域名

    //公众号appid
    public static String PUBLIC_JSAPI="wxe4eb392abf5d482c";
    //public static String PUBLIC_JSAPI="wx36e1e332a09a513a";//测试

    public static String appsecret="d3760f8ea78ce55cf302c6e96aa25097";
    //public static String appsecret="d883775bd8c590a411f78a399f4f7b4d";//测试

    //商户号
    public  static String  MCHID_JSAPI="1592794811";

    //交易类型
    public static String  TRADE_TYPE="JSAPI";

    //服务器地址，终端IP
    public static String  SPBILL_CREATE_IP="47.94.143.11";

    //证书名字
    public static String  THE_CERTIFICATE_OF_JSAPI="hehe.p12";

    //回调通知地址
    public static String  NOTIFY_URL_PAY_SUCCESS="https://at.sia-edu.com/order/orderResult";

    //回调通知地址
    public static String  NOTIFY_URL_CURRENCY="http://kph48t.natappfree.cc/WXPay/orderResult";

    //生成的key，需要到商户平台生成,用于签名
    public static String KEY="95f72774ad221c903b256d39b2b62414";

    //所支付的名称（xx课程）
    public static String  BODY= "TISHINENG"; //"体是能（北京）教育科技有限公司";

    //nonce_str 随机字符串
    public static String  NONCE_STR="uuid";
    //商户订单号
    public static String  OUT_TRADE_NO="";
    //金额，单位分
    public static String TOTAL_FEE="";
    //签名
    public static String SIGN="";


    //tonken
    public static String token="zhong";

    //初始化请求Map
    public static Map<String,String> toMapJSAPI(){
        Map<String,String> map=new HashMap<String, String>();
        map.put("appid",APPID_JSAPI);//公众号id
        map.put("mch_id",MCHID_JSAPI);//商户号
        map.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        map.put("body",BODY);//商品描述
        map.put("spbill_create_ip",SPBILL_CREATE_IP);//终端ip地址
        map.put("trade_type",TRADE_TYPE);//交易类型
        map.put("notify_url", WXConfig.NOTIFY_URL_PAY_SUCCESS);//回调地址
        map.put("openid", WXConfig.NOTIFY_URL_CURRENCY);//用户标识
        return  map;
    }

}
