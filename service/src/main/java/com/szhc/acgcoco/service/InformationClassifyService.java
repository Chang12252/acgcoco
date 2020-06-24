package com.szhc.acgcoco.service;

import com.szhc.acgcoco.base.entity.dto.InformationClassifyDTO;
import com.szhc.acgcoco.dao.InformationClassifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资讯分类(InformationClassify)表服务实现类
 *
 * @author makejava
 * @since 2020-06-23 23:38:57
 */
@Service("informationClassifyService")
public class InformationClassifyService  {
    @Autowired
    private InformationClassifyDAO informationClassifyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public InformationClassifyDTO queryById(Integer id) {
        return this.informationClassifyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<InformationClassifyDTO> queryAllByLimit(int offset, int limit) {
        return this.informationClassifyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param informationClassify 实例对象
     * @return 实例对象
     */
    public InformationClassifyDTO insert(InformationClassifyDTO informationClassify) {
        this.informationClassifyDao.insert(informationClassify);
        return informationClassify;
    }

    /**
     * 修改数据
     *
     * @param informationClassify 实例对象
     * @return 实例对象
     */
    public InformationClassifyDTO update(InformationClassifyDTO informationClassify) {
        this.informationClassifyDao.update(informationClassify);
        return this.queryById(informationClassify.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.informationClassifyDao.deleteById(id) > 0;
    }

    public List<InformationClassifyDTO> queryAll() {
        return informationClassifyDao.queryAll();
    }
}