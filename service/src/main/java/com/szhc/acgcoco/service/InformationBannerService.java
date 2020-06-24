package com.szhc.acgcoco.service;

import com.szhc.acgcoco.base.entity.dto.InformationBannerDTO;
import com.szhc.acgcoco.dao.InformationBannerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 资讯banner(InformationBanner)表服务实现类
 *
 * @author makejava
 * @since 2020-06-23 23:36:32
 */
@Service("informationBannerService")
public class InformationBannerService {
    @Autowired
    private InformationBannerDAO informationBannerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public InformationBannerDTO queryById(Long id) {
        return this.informationBannerDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<InformationBannerDTO> queryAllByLimit(int offset, int limit) {
        return this.informationBannerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param informationBanner 实例对象
     * @return 实例对象
     */
    public InformationBannerDTO insert(InformationBannerDTO informationBanner) {
        this.informationBannerDao.insert(informationBanner);
        return informationBanner;
    }

    /**
     * 修改数据
     *
     * @param informationBanner 实例对象
     * @return 实例对象
     */
    public InformationBannerDTO update(InformationBannerDTO informationBanner) {
        this.informationBannerDao.update(informationBanner);
        return this.queryById(informationBanner.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.informationBannerDao.deleteById(id) > 0;
    }

    public List<InformationBannerDTO> queryAll() {
      return informationBannerDao.queryAll();
    }
}