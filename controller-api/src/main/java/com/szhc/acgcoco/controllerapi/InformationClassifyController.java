package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.dto.InformationBannerDTO;
import com.szhc.acgcoco.base.entity.dto.InformationClassifyDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.InformationBannerService;
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


    /**
     * 添加 分类
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/addInformationClassify",method = RequestMethod.POST)
    public ResultDTO addInformationClassify(@RequestBody InformationClassifyDTO dto) {
        if(!verifyParam(dto.getName())){
            return ResultDTOBuilder.failure("000001");
        }
        service.insert(dto);
        return ResultDTOBuilder.success();
    }


    /**
     * 修改 分类
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/updateInformationClassify",method = RequestMethod.POST)
    public ResultDTO updateInformationClassify(@RequestBody InformationClassifyDTO dto) {
        if(!verifyParam(dto.getName(),dto.getId())){
            return ResultDTOBuilder.failure("000001");
        }
        service.update(dto);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除 分类
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/deleteInformationClassify",method = RequestMethod.POST)
    public ResultDTO deleteInformationClassify(@RequestBody InformationClassifyDTO dto) {
        if(!verifyParam(dto.getId())){
            return ResultDTOBuilder.failure("000001");
        }
        service.deleteById(dto.getId());
        return ResultDTOBuilder.success();
    }

}