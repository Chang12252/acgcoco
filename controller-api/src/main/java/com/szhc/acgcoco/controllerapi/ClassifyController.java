package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiaxowen
 * @since 2020-05-21 18:34:34
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController extends BaseController {


    @Autowired
    private ClassifyService  classifyServicee;

    /**
     * 查询所有类型
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/queryClassifyAll",method = RequestMethod.POST)
    public ResultDTO queryClassifyAll() {
        return ResultDTOBuilder.success(classifyServicee.queryClassifyAll());
    }






}
