package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.bo.TestBO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author xiaxowen
 * @since 2020-05-21 18:34:34
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {


    /**
     * 查询所有类型
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResultDTO test() {
        List<TestBO> list=new ArrayList<TestBO>();
        for(int i=1;i<11;i++){
            TestBO testBO = new TestBO();
            testBO.setId(i);
            testBO.setPost_id(i==1?0:i-1);
            testBO.setTitle("为什么自动驾驶诉讼不断？"+i);
            testBO.setAuthor_name("汽车报");
            testBO.setCover("https://img.36krcdn.com/20200411/v2_16417a06088947debe0450950f8fc813_img_png");
            testBO.setPublished_at(new Date());
            testBO.setComments_count(0);
            testBO.setContent("123123123");
            list.add(testBO);
        }
        return ResultDTOBuilder.success(list);
    }






}
