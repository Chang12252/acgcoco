package com.szhc.acgcoco.base.util.wechat.config;

public class IWXPayDomainImpl implements IWXPayDomain {

    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    public DomainInfo getDomain(WXRequestConfig config) {
        return new DomainInfo("api.mch.weixin.qq.com",false);
    }
}
