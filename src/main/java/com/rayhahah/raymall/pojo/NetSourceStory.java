package com.rayhahah.raymall.pojo;

import java.util.Date;

public class NetSourceStory {
    private Integer id;

    private String storyFrom;

    private String url;

    private String urlObjectId;

    private String storyTitle;

    private String storyContent;

    private String storyCategory;

    private String storyLabel;

    private String storyHot;

    private Date createTime;

    private Date updateTime;

    public NetSourceStory(Integer id, String storyFrom, String url, String urlObjectId, String storyTitle, String storyContent, String storyCategory, String storyLabel, String storyHot, Date createTime, Date updateTime) {
        this.id = id;
        this.storyFrom = storyFrom;
        this.url = url;
        this.urlObjectId = urlObjectId;
        this.storyTitle = storyTitle;
        this.storyContent = storyContent;
        this.storyCategory = storyCategory;
        this.storyLabel = storyLabel;
        this.storyHot = storyHot;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public NetSourceStory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoryFrom() {
        return storyFrom;
    }

    public void setStoryFrom(String storyFrom) {
        this.storyFrom = storyFrom == null ? null : storyFrom.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlObjectId() {
        return urlObjectId;
    }

    public void setUrlObjectId(String urlObjectId) {
        this.urlObjectId = urlObjectId == null ? null : urlObjectId.trim();
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle == null ? null : storyTitle.trim();
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent == null ? null : storyContent.trim();
    }

    public String getStoryCategory() {
        return storyCategory;
    }

    public void setStoryCategory(String storyCategory) {
        this.storyCategory = storyCategory == null ? null : storyCategory.trim();
    }

    public String getStoryLabel() {
        return storyLabel;
    }

    public void setStoryLabel(String storyLabel) {
        this.storyLabel = storyLabel == null ? null : storyLabel.trim();
    }

    public String getStoryHot() {
        return storyHot;
    }

    public void setStoryHot(String storyHot) {
        this.storyHot = storyHot == null ? null : storyHot.trim();
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