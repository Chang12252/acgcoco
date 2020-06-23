package com.szhc.acgcoco.base.entity.dto;

import java.util.Date;
import java.io.Serializable;

/**
 * 话题(Topic)实体类
 *
 * @author makejava
 * @since 2020-06-20 14:44:17
 */
public class TopicDTO implements Serializable {
    private static final long serialVersionUID = -27688724625030990L;
    
    private Long id;
    /**
    * 分类id
    */
    private Long classifyId;
    /**
    * 话题内容
    */
    private String topicContent;
    /**
    * 创建时间
    */
    private Date createTime;

    private String icon;//图标

    private String intro;//简介

    private int status;// 状态
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}