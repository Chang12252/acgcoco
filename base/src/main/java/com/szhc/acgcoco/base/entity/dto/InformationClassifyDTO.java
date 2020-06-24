package com.szhc.acgcoco.base.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯分类(InformationClassify)实体类
 *
 * @author makejava
 * @since 2020-06-23 23:38:55
 */
public class InformationClassifyDTO implements Serializable {
    private static final long serialVersionUID = 929869810123128523L;
    
    private Integer id;
    /**
    * 分类名称
    */
    private String name;
    
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}