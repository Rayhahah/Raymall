package com.rayhahah.raymall.pojo;

import java.util.Date;

public class ESCrashMessage {
    private Integer id;

    private Integer userId;

    private String versionName;

    private String versionCode;

    private String deviceInfo;

    private String exceptionInfo;

    private String systemInfo;

    private String secureInfo;

    private String memoryInfo;

    private Date createTime;

    private Date updateTime;

    public ESCrashMessage(Integer id, Integer userId, String versionName, String versionCode, String deviceInfo, String exceptionInfo, String systemInfo, String secureInfo, String memoryInfo, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.deviceInfo = deviceInfo;
        this.exceptionInfo = exceptionInfo;
        this.systemInfo = systemInfo;
        this.secureInfo = secureInfo;
        this.memoryInfo = memoryInfo;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ESCrashMessage() {
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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo == null ? null : exceptionInfo.trim();
    }

    public String getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(String systemInfo) {
        this.systemInfo = systemInfo == null ? null : systemInfo.trim();
    }

    public String getSecureInfo() {
        return secureInfo;
    }

    public void setSecureInfo(String secureInfo) {
        this.secureInfo = secureInfo == null ? null : secureInfo.trim();
    }

    public String getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(String memoryInfo) {
        this.memoryInfo = memoryInfo == null ? null : memoryInfo.trim();
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