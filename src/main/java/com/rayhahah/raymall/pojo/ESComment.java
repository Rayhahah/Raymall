package com.rayhahah.raymall.pojo;

import java.util.Date;

public class ESComment {
    private Integer id;

    private Integer userId;

    private String versionName;

    private String versionCode;

    private String comment;

    private Date createTime;

    private Date updateTime;

    public ESComment(Integer id, Integer userId, String versionName, String versionCode, String comment, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ESComment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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