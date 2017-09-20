package com.rayhahah.raymall.pojo;

import java.util.Date;

public class ESVersion {
    private Integer id;

    private String versionName;

    private String versionCode;

    private String description;

    private String url;

    private Date createTime;

    private Date updateTime;

    public ESVersion(Integer id, String versionName, String versionCode, String description, String url, Date createTime, Date updateTime) {
        this.id = id;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.description = description;
        this.url = url;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ESVersion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode == null ? null : versionCode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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