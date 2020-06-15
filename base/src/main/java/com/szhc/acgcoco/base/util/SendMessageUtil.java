package com.szhc.acgcoco.base.util;


import com.alibaba.druid.util.StringUtils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;


/**
 * Created by Administrator on 2019/12/30.
 */
public class SendMessageUtil {

    static String accessKeyId="LTAI4Fzo7UBVT3U9UpkESV2j";
    static String accessSecret="2vyr8zOUKUxFsy48QWbZU7RumEPNZO";


    public static CommonResponse sendSignInCodeMessage(String mobile, String content,String templateCode){
        DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "体是能");
        //request.putQueryParameter("TemplateCode", "SMS_188720062");
        if(StringUtils.isEmpty(templateCode)){
            request.putQueryParameter("TemplateCode", "SMS_188720062");
        }else {
            request.putQueryParameter("TemplateCode", templateCode);
        }
        request.putQueryParameter("TemplateParam", "{\"code\":\""+content+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args){
        sendSignInCodeMessage("18810745842","666666","");
    }

}
