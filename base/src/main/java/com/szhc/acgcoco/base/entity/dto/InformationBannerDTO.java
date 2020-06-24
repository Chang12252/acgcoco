package com.szhc.acgcoco.base.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯banner(InformationBanner)实体类
 *
 * @author makejava
 * @since 2020-06-23 23:36:31
 */
public class InformationBannerDTO implements Serializable {
    private static final long serialVersionUID = 312874781086643929L;
    
    private Long id;
    /**
    * 跳转路径
    */
    private String path;
    
    private Date createTime;
    /**
    * 排序
    */
    private Integer sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}