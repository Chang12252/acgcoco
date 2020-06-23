package com.szhc.acgcoco.service;

import com.szhc.acgcoco.base.entity.bo.ClassifyBO;
import com.szhc.acgcoco.base.entity.bo.TopicBO;
import com.szhc.acgcoco.base.entity.dto.TopicDTO;
import com.szhc.acgcoco.dao.TopicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 话题(Topic)表服务实现类
 *
 * @author makejava
 * @since 2020-06-20 14:44:19
 */
@Service("topicService")
public class TopicService {
    @Autowired
    private TopicDAO topicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public TopicDTO queryById(Long id) {
        return this.topicDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<TopicDTO> queryAllByLimit(int offset, int limit) {
        return this.topicDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    public TopicDTO insert(TopicDTO topic) {
        this.topicDao.insert(topic);
        return topic;
    }

    /**
     * 修改数据
     *
     * @param topic 实例对象
     * @return 实例对象
     */
    public TopicDTO update(TopicDTO topic) {
        this.topicDao.update(topic);
        return this.queryById(topic.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.topicDao.deleteById(id) > 0;
    }

    public List<ClassifyBO> queryTopicAll() {
        return topicDao.queryTopicAll();
    }
}