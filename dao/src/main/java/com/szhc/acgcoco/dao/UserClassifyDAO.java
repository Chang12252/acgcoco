package com.szhc.acgcoco.dao;

import com.szhc.acgcoco.base.entity.dto.UserClassifyDTO;
import com.szhc.acgcoco.base.entity.bo.UserClassifyBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户分类(UserClassify)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-20 01:32:39
 */
@Component
public interface UserClassifyDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserClassifyDTO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserClassifyDTO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userClassify 实例对象
     * @return 对象列表
     */
    List<UserClassifyDTO> queryAll(UserClassifyDTO userClassify);

    /**
     * 新增数据
     *
     * @param userClassify 实例对象
     * @return 影响行数
     */
    int insert(UserClassifyDTO userClassify);

    /**
     * 修改数据
     *
     * @param userClassify 实例对象
     * @return 影响行数
     */
    int update(UserClassifyDTO userClassify);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 查询全部用户分类 排序
     * @return
     */
    List<UserClassifyBO> queryUserClassifyAll(@Param("userId") Long userId);
}