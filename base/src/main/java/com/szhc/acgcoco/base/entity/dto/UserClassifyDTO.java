package com.szhc.acgcoco.base.entity.dto;

import java.io.Serializable;

/**
 * 用户分类(UserClassify)实体类
 *
 * @author makejava
 * @since 2020-06-20 01:32:38
 */
public class UserClassifyDTO implements Serializable {
    private static final long serialVersionUID = 944937486485686368L;
    
    private Long id;
    /**
    * 分类id
    */
    private Long classifyId;
    
    private Long userId;
    /**
    * 排序
    */
    private Integer sort;
    
    private String type;


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}