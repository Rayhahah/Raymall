package com.rayhahah.raymall.pojo;

import java.util.Date;

public class JiJianAppIp {
    private Integer id;

    private String name;

    private String url;

    private Date createTime;

    private Date updateTime;

    public JiJianAppIp(Integer id, String name, String url, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public JiJianAppIp() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}