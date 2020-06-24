package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.InformationBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiaxowen
 * 资讯 banner
 * @since 2020-05-21 18:34:34
 */
@RestController
@RequestMapping("/informationBanner")
public class InformationBannerController extends BaseController {

    @Autowired
    private InformationBannerService  service;

    /**
     * 查询所有
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    public ResultDTO queryClassifyAll() {
        return ResultDTOBuilder.success(service.queryAll());
    }





}