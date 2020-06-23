package com.szhc.acgcoco.base.entity.bo;

import java.util.List;
//分类
public class ClassifyBO {

    private Long id;// 分类id
    private String name;// 分类名称
    private String type;//分类类型
    private List<TopicBO> topics; //


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TopicBO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicBO> topics) {
        this.topics = topics;
    }


}
