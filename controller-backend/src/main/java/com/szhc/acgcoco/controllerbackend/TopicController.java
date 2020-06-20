package com.szhc.acgcoco.controllerbackend;

import com.szhc.acgcoco.base.entity.dto.ClassifyDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerbackend.base.BaseController;
import com.szhc.acgcoco.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 话题
 */

@RestController
@RequestMapping("/topic")
public class TopicController extends BaseController {

    @Autowired
    private TopicService topicService;
    /**
     * 查询所有类型
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/queryTopicAll",method = RequestMethod.POST)
    public ResultDTO queryTopic() {
        topicService.queryTopicAll();
        return ResultDTOBuilder.success();
    }


    /**
     * 添加分类
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/addClassify",method = RequestMethod.POST)
    public ResultDTO addClassify(@RequestBody ClassifyDTO classifyDTO) {
        //验证参数
        if(!verifyParam(classifyDTO.getName(),classifyDTO.getType())) {
            return  ResultDTOBuilder.failure("00001");
        }
        topicService.insert(null);
        return ResultDTOBuilder.success();
    }




}
