package com.szhc.acgcoco.service;

import com.szhc.acgcoco.base.entity.dto.UserClassifyDTO;
import com.szhc.acgcoco.base.entity.bo.UserClassifyBO;
import com.szhc.acgcoco.base.entity.param.Sort;
import com.szhc.acgcoco.base.entity.param.SortParam;
import com.szhc.acgcoco.dao.UserClassifyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户分类(UserClassify)表服务实现类
 *
 * @author makejava
 * @since 2020-06-20 01:32:39
 */
@Service("userClassifyService")
public class UserClassifyService {
    @Autowired
    private UserClassifyDAO userClassifyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public UserClassifyDTO queryById(Long id) {
        return this.userClassifyDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<UserClassifyDTO> queryAllByLimit(int offset, int limit) {
        return this.userClassifyDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userClassify 实例对象
     * @return 实例对象
     */
    public UserClassifyDTO insert(UserClassifyDTO userClassify) {
        this.userClassifyDao.insert(userClassify);
        return userClassify;
    }

    /**
     * 修改数据
     *
     * @param userClassify 实例对象
     * @return 实例对象
     */
    public UserClassifyDTO update(UserClassifyDTO userClassify) {
        this.userClassifyDao.update(userClassify);
        return this.queryById(userClassify.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.userClassifyDao.deleteById(id) > 0;
    }

    public List<UserClassifyBO> queryUserClassifyAll(Long userId) {
        return userClassifyDao.queryUserClassifyAll(userId);
    }

    /**
     * 修改排序
     * @param sortParam
     */
    public void sort(SortParam sortParam) {
        for (Sort s: sortParam.getList()) {
            UserClassifyDTO userClassify = new UserClassifyDTO();
            userClassify.setId(s.getId());
            userClassify.setSort(s.getSort());
            userClassifyDao.update(userClassify);
        }
    }

}