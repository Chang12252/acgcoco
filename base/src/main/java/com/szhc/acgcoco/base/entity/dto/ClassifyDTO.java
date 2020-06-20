package com.szhc.acgcoco.base.entity.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 类型表(Classify)实体类
 *
 * @author makejava
 * @since 2020-06-19 23:39:33
 */
public class ClassifyDTO implements Serializable {
    private static final long serialVersionUID = -82456627929452954L;
    
    private Long id;
    
    private String name;
    
    private Date createTime;
    /**
    * 类型  分类还是/系统级
    */
    private String type;

    private int status; // 状态 0 正常 1 删除


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}