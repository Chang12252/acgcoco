package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.bo.ClassifyBO;
import com.szhc.acgcoco.base.entity.bo.TopicBO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.base.entity.dto.TopicDTO;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author xiaxowen
 * @since 2020-05-21 18:34:34
 * 话题呦
 */
@RestController
@RequestMapping("/topic")
public class TopicController extends BaseController {


    @Autowired
    private TopicService topicService;

    /**
     * 查询所有话题
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/queryTopicAll",method = RequestMethod.POST)
    public ResultDTO queryTopicAll(){
        List<ClassifyBO> topicBOS = topicService.queryTopicAll();
        return ResultDTOBuilder.success(topicBOS);
    }



}