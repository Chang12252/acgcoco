package com.szhc.acgcoco.dao;

import com.szhc.acgcoco.base.entity.dto.InformationClassifyDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资讯分类(InformationClassify)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-23 23:38:56
 */
@Component
public interface InformationClassifyDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InformationClassifyDTO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<InformationClassifyDTO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     * @return 对象列表
     */
    List<InformationClassifyDTO> queryAll();

    /**
     * 新增数据
     *
     * @param informationClassify 实例对象
     * @return 影响行数
     */
    int insert(InformationClassifyDTO informationClassify);

    /**
     * 修改数据
     *
     * @param informationClassify 实例对象
     * @return 影响行数
     */
    int update(InformationClassifyDTO informationClassify);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}