package com.szhc.acgcoco.base.util;

import com.aliyuncs.utils.StringUtils;

public class PageUtil {
    private Long pageNo=new Long(1);
    private Long pageSize=new Long(10);

    public PageUtil() {

    }

    public PageUtil(Long pageNo, Long pageSize) {
        if(pageNo!=null)
        this.pageNo = pageNo;
        if(pageSize!=null)
        this.pageSize = pageSize;
    }

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        if(!StringUtils.isEmpty(pageNo)){
            this.pageNo = Long.parseLong(pageNo);
        }

    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        if(!StringUtils.isEmpty(pageSize)){
            this.pageSize = Long.parseLong(pageSize);
        }

    }
}
