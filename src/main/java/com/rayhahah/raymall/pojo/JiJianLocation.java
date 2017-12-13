package com.rayhahah.raymall.pojo;

import java.util.Date;

public class JiJianLocation {
    private Integer id;

    private String username;

    private String latitude;

    private String longtitude;

    private Long time;

    private Date createTime;

    private Date updateTime;

    public JiJianLocation(Integer id, String username, String latitude, String longtitude, Long time, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.time = time;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public JiJianLocation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude == null ? null : longtitude.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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