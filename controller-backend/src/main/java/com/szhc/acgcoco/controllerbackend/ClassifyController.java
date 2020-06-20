package com.szhc.acgcoco.controllerbackend;

import com.szhc.acgcoco.base.entity.dto.ClassifyDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.controllerbackend.base.BaseController;
import com.szhc.acgcoco.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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


    /**
     * 添加分类
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/addClassify",method = RequestMethod.POST)
    public ResultDTO addClassify(@RequestBody ClassifyDTO classifyDTO) {
        //验证参数
        if(!verifyParam(classifyDTO.getName(),classifyDTO.getType())) {
            return   ResultDTOBuilder.failure("00001");
        }
        classifyServicee.insert(classifyDTO);
        return ResultDTOBuilder.success();
    }

    /**
     * 修改分类
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/updateClassify",method = RequestMethod.POST)
    public ResultDTO updateClassify(@RequestBody ClassifyDTO classifyDTO) {
        //验证参数
        if(!verifyParam(classifyDTO.getName(),classifyDTO.getType())) {
            return  ResultDTOBuilder.failure("00001");
        }
        classifyServicee.update(classifyDTO);
        return ResultDTOBuilder.success();
    }

    /**
     * 删除分类
     *
     * @author  wangxiaokun
     */
    @RequestMapping(value = "/deleteClassify",method = RequestMethod.POST)
    public ResultDTO deleteClassify(@RequestBody ClassifyDTO classifyDTO) {
        //验证参数
        if(!verifyParam(classifyDTO.getId())) {
           return   ResultDTOBuilder.failure("00001");
        }
        classifyDTO.setStatus(1);
        classifyServicee.update(classifyDTO);
        return ResultDTOBuilder.success();
    }


}
