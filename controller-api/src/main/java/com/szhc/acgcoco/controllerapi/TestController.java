package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.dto.ResultDTO;
import com.szhc.acgcoco.base.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.wechatmession.TestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    TestServer testServer;




    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResultDTO queryAll(@RequestBody Map<String,String> map) {
       testServer.test(map);
        return ResultDTOBuilder.success();
    }
}
