package com.szhc.acgcoco.service;

import com.szhc.acgcoco.base.entity.dto.ClassifyDTO;
import com.szhc.acgcoco.dao.ClassifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类型表(Classify)表服务实现类
 *
 * @author makejava
 * @since 2020-06-19 23:39:36
 */
@Service("classifyService")
public class ClassifyService {
    @Autowired
    private ClassifyDAO classifyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public ClassifyDTO queryById(Long id) {
        return this.classifyDao.queryById(id);
    }

    /**
     * @return 对象列表
     */
    public List<ClassifyDTO> queryClassifyAll() {
        return this.classifyDao.queryClassifyAll();
    }

    /**
     * 新增数据
     *
     * @param classify 实例对象
     * @return 实例对象
     */
    public ClassifyDTO insert(ClassifyDTO classify) {
        this.classifyDao.insert(classify);
        return classify;
    }

    /**
     * 修改数据
     *
     * @param classify 实例对象
     * @return 实例对象
     */
    public ClassifyDTO update(ClassifyDTO classify) {
        this.classifyDao.update(classify);
        return this.queryById(classify.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.classifyDao.deleteById(id) > 0;
    }
}