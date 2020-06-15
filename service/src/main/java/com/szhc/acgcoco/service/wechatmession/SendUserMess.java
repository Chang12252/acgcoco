package com.szhc.acgcoco.service.wechatmession;

import com.szhc.acgcoco.base.util.DateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import weixin.popular.api.MessageAPI;
import weixin.popular.bean.message.templatemessage.TemplateMessage;
import weixin.popular.bean.message.templatemessage.TemplateMessageItem;
import weixin.popular.bean.message.templatemessage.TemplateMessageResult;
import weixin.popular.support.TokenManager;

import java.util.LinkedHashMap;


@Service
public class SendUserMess {


    //拼单失败
    @Async
    public void sendUserOrderFailure(String openId,String title,String content) {

        //access_token  toUserName=gh_182f63e6e9d5,fromUserName=o3HSmjopCnl9K_3iU_1Awg0RFHiQ,createTime=1591443001,
        String access_token = TokenManager.getDefaultToken();
        TemplateMessage message = new TemplateMessage();
        message.setUrl("http://s6dh2b.natappfree.cc/wx/Test"); //点击跳转小程序地址
        message.setTemplate_id("KmGD1BlNxIx8i6DTBu3kGdZaFSr0-zfb0HRwA1mnW70"); // 模板id
        message.setTouser(openId); // poenId
        LinkedHashMap<String, TemplateMessageItem> data = new LinkedHashMap<>();
        data.put("first",new TemplateMessageItem("中经集团", "bule"));
        data.put("keyword1",new TemplateMessageItem(title, "bule"));
        data.put("keyword2",new TemplateMessageItem(DateUtil.getNow(), "bule"));
        data.put("keyword3",new TemplateMessageItem("数字化云管家", "bule"));
        data.put("remark", new TemplateMessageItem(content, "bule"));
        message.setData(data);
        TemplateMessageResult templateMessage = MessageAPI.messageTemplateSend(access_token, message);
    }

}
