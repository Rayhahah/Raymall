package com.rayhahah.raymall.pojo;

import java.util.Date;

public class ESLive {
    private Integer id;

    private String username;

    private String screenname;

    private String pushUrl;

    private String streamId;

    private String rtmpUrl;

    private String flvUrl;

    private String hlsUrl;

    private String picUrl;

    private String videoUrl;

    private String liveStatus;

    private String fileFormat;

    private Date createTime;

    private Date updateTime;

    public ESLive(Integer id, String username, String screenname, String pushUrl, String streamId, String rtmpUrl, String flvUrl, String hlsUrl, String picUrl, String videoUrl, String liveStatus, String fileFormat, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.screenname = screenname;
        this.pushUrl = pushUrl;
        this.streamId = streamId;
        this.rtmpUrl = rtmpUrl;
        this.flvUrl = flvUrl;
        this.hlsUrl = hlsUrl;
        this.picUrl = picUrl;
        this.videoUrl = videoUrl;
        this.liveStatus = liveStatus;
        this.fileFormat = fileFormat;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ESLive() {
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

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname == null ? null : screenname.trim();
    }

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl == null ? null : pushUrl.trim();
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId == null ? null : streamId.trim();
    }

    public String getRtmpUrl() {
        return rtmpUrl;
    }

    public void setRtmpUrl(String rtmpUrl) {
        this.rtmpUrl = rtmpUrl == null ? null : rtmpUrl.trim();
    }

    public String getFlvUrl() {
        return flvUrl;
    }

    public void setFlvUrl(String flvUrl) {
        this.flvUrl = flvUrl == null ? null : flvUrl.trim();
    }

    public String getHlsUrl() {
        return hlsUrl;
    }

    public void setHlsUrl(String hlsUrl) {
        this.hlsUrl = hlsUrl == null ? null : hlsUrl.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus == null ? null : liveStatus.trim();
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat == null ? null : fileFormat.trim();
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