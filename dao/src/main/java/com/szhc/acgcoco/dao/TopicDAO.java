package com.szhc.acgcoco.dao;

import com.szhc.acgcoco.base.entity.bo.ClassifyBO;
import com.szhc.acgcoco.base.entity.bo.TopicBO;
import com.szhc.acgcoco.base.entity.dto.TopicDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 话题(Topic)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-20 14:44:17
 */
@Component
public interface TopicDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TopicDTO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TopicDTO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param topic 实例对象
     * @return 对象列表
     */
    List<TopicDTO> queryAll(TopicDTO topic);

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 影响行数
     */
    int insert(TopicDTO topic);

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 影响行数
     */
    int update(TopicDTO topic);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<ClassifyBO> queryTopicAll();

}