package com.szhc.acgcoco.dao;

import com.szhc.acgcoco.base.entity.dto.InformationBannerDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 资讯banner(InformationBanner)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-23 23:36:31
 */
@Component
public interface InformationBannerDAO {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InformationBannerDTO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<InformationBannerDTO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<InformationBannerDTO> queryAll();

    /**
     * 新增数据
     *
     * @param informationBanner 实例对象
     * @return 影响行数
     */
    int insert(InformationBannerDTO informationBanner);

    /**
     * 修改数据
     *
     * @param informationBanner 实例对象
     * @return 影响行数
     */
    int update(InformationBannerDTO informationBanner);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}