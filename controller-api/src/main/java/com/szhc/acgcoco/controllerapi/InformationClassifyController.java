package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.dto.InformationClassifyDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.InformationClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiaxowen
 * 资讯 分类
 * @since 2020-05-21 18:34:34
 */
@RestController
@RequestMapping("/informationClassify")
public class InformationClassifyController extends BaseController {

    @Autowired
    private InformationClassifyService  service;

    /**
     * 查询所有
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    public ResultDTO queryAll() {
        return ResultDTOBuilder.success(service.queryAll());
    }




}