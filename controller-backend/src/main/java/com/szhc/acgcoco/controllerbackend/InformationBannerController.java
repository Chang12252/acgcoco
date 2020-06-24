package com.szhc.acgcoco.controllerbackend;

import com.szhc.acgcoco.base.entity.dto.InformationBannerDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerbackend.base.BaseController;
import com.szhc.acgcoco.service.InformationBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * 添加banner
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/addInformationBanner",method = RequestMethod.POST)
    public ResultDTO addInformationBanner(@RequestBody InformationBannerDTO dto) {
        if(!verifyParam(dto.getPath())){
            return ResultDTOBuilder.failure("00001");
        }
        service.insert(dto);
        return ResultDTOBuilder.success();
    }


    /**
     * 修改banner
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/updateInformationBanner",method = RequestMethod.POST)
    public ResultDTO updateInformationBanner(@RequestBody InformationBannerDTO dto) {
        if(!verifyParam(dto.getPath(),dto.getId())){
            return ResultDTOBuilder.failure("00001");
        }
        service.update(dto);
        return ResultDTOBuilder.success();
    }


    /**
     * 删除banner
     *
     * @return List<BannerBO>
     * @author  wangxiaokun
     */
        @RequestMapping(value = "/deleteInformationBanner",method = RequestMethod.POST)
    public ResultDTO deleteInformationBanner(@RequestBody InformationBannerDTO dto) {
        if(!verifyParam(dto.getId())){
            return ResultDTOBuilder.failure("00001");
        }
        service.deleteById(dto.getId());
        return ResultDTOBuilder.success();
    }



}