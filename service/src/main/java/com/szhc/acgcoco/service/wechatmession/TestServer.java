package com.szhc.acgcoco.service.wechatmession;

import com.szhc.acgcoco.base.entity.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServer {
    @Autowired
    MongoTemplate mongoTemplate;

    public void test(Map<String,String> map){
        UserBO userBO=new UserBO();
        userBO.setId(1L);
        userBO.setName("何小汶");
        mongoTemplate.insert(userBO);
    }


}
