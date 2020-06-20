package com.szhc.acgcoco.controllerapi;

import com.szhc.acgcoco.base.entity.dto.ResultDTO;
import com.szhc.acgcoco.base.entity.dto.ResultDTOBuilder;
import com.szhc.acgcoco.base.entity.dto.UserClassifyDTO;
import com.szhc.acgcoco.base.entity.bo.UserBO;
import com.szhc.acgcoco.base.entity.param.SortParam;
import com.szhc.acgcoco.controllerapi.base.BaseController;
import com.szhc.acgcoco.service.UserClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xiaxowen
 * 用户分类
 * @since 2020-05-21 18:34:34
 */
@RestController
@RequestMapping("/userClassify")
public class UserClassifyController extends BaseController {

    @Autowired
    private UserClassifyService userClassifyService;

    /**
     * 查询所有类型
     *
     * @return List<BannerBO>
     * @author wangxiaokun
     */
    @RequestMapping(value = "/queryUserClassifyAll", method = RequestMethod.POST)
    public ResultDTO queryUserClassifyAll(HttpServletRequest request) {
        UserBO loginUser = super.getLoginUser(request);
        return ResultDTOBuilder.success(userClassifyService.queryUserClassifyAll(loginUser.getId()));
    }

    /**
     * 添加用户分类
     *
     * @author wangxiaokun
     */
    @RequestMapping(value = "/addUserClassify", method = RequestMethod.POST)
    public ResultDTO addClassify(@RequestBody UserClassifyDTO userClassify, HttpServletRequest request) {
        //验证参数
        if (!verifyParam(userClassify.getClassifyId())) {
            return ResultDTOBuilder.failure("00001");
        }
        UserBO loginUser = super.getLoginUser(request);
        userClassify.setUserId(loginUser.getId()); //设置用户
        userClassifyService.insert(userClassify);
        return ResultDTOBuilder.success();
    }

    /**
     * 删除用户分类
     *
     * @author wangxiaokun
     */
    @RequestMapping(value = "/deleteUserClassify", method = RequestMethod.POST)
    public ResultDTO deleteClassify(@RequestBody UserClassifyDTO userClassify) {
        //验证参数
        if (!verifyParam(userClassify.getId())) {
            return ResultDTOBuilder.failure("00001");
        }
        userClassifyService.deleteById(userClassify.getId());
        return ResultDTOBuilder.success();
    }


    /**
     * 修改用户分类排序
     *
     * @author wangxiaokun
     */
    @RequestMapping(value = "/updateUserClassify", method = RequestMethod.POST)
    public ResultDTO updateClassify(@RequestBody SortParam  sortParam) {
        //验证参数
        if (sortParam.getList()==null || sortParam.getList().size()==0) {
            return ResultDTOBuilder.failure("00001");
        }
        userClassifyService.sort(sortParam);
        return ResultDTOBuilder.success();
    }


}
