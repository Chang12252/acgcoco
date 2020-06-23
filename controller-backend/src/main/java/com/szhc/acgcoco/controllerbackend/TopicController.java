package com.szhc.acgcoco.controllerbackend;

import com.szhc.acgcoco.base.entity.bo.ClassifyBO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.base.entity.dto.TopicDTO;
import com.szhc.acgcoco.controllerbackend.base.BaseController;
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

    /**
     * 添加话题
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/addTopic",method = RequestMethod.POST)
    public ResultDTO addTopic(@RequestBody TopicDTO topicDTO){
        if(!verifyParam(topicDTO.getClassifyId(),topicDTO.getTopicContent())){
            ResultDTOBuilder.failure("000001");
        }
        topicService.insert(topicDTO);
        return ResultDTOBuilder.success();
    }


    /**
     * 修改话题
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/updateTopic",method = RequestMethod.POST)
    public ResultDTO updateTopic(@RequestBody TopicDTO topicDTO){
        if(!verifyParam(topicDTO.getClassifyId(),topicDTO.getId())){
            ResultDTOBuilder.failure("000001");
        }
        topicService.update(topicDTO);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除话题
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/deleteTopic",method = RequestMethod.POST)
    public ResultDTO deleteTopic(@RequestBody TopicDTO topicDTO){
        if(!verifyParam(topicDTO.getId())){
            ResultDTOBuilder.failure("000001");
        }
        topicDTO.setStatus(1);
        topicService.update(topicDTO);
        return ResultDTOBuilder.success();
    }


}