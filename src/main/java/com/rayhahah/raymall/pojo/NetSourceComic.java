package com.rayhahah.raymall.pojo;

import java.util.Date;

public class NetSourceComic {
    private Integer id;

    private String comicFrom;

    private String url;

    private String urlObjectId;

    private String comicTitle;

    private String comicCover;

    private String comicContent;

    private String comicAuthor;

    private String comicCategory;

    private String comicStatus;

    private String comicLabel;

    private String comicHot;

    private String comicPage;

    private String comicTime;

    private Date createTime;

    private Date updateTime;

    public NetSourceComic(Integer id, String comicFrom, String url, String urlObjectId, String comicTitle, String comicCover, String comicContent, String comicAuthor, String comicCategory, String comicStatus, String comicLabel, String comicHot, String comicPage, String comicTime, Date createTime, Date updateTime) {
        this.id = id;
        this.comicFrom = comicFrom;
        this.url = url;
        this.urlObjectId = urlObjectId;
        this.comicTitle = comicTitle;
        this.comicCover = comicCover;
        this.comicContent = comicContent;
        this.comicAuthor = comicAuthor;
        this.comicCategory = comicCategory;
        this.comicStatus = comicStatus;
        this.comicLabel = comicLabel;
        this.comicHot = comicHot;
        this.comicPage = comicPage;
        this.comicTime = comicTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public NetSourceComic() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComicFrom() {
        return comicFrom;
    }

    public void setComicFrom(String comicFrom) {
        this.comicFrom = comicFrom == null ? null : comicFrom.trim();
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

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle == null ? null : comicTitle.trim();
    }

    public String getComicCover() {
        return comicCover;
    }

    public void setComicCover(String comicCover) {
        this.comicCover = comicCover == null ? null : comicCover.trim();
    }

    public String getComicContent() {
        return comicContent;
    }

    public void setComicContent(String comicContent) {
        this.comicContent = comicContent == null ? null : comicContent.trim();
    }

    public String getComicAuthor() {
        return comicAuthor;
    }

    public void setComicAuthor(String comicAuthor) {
        this.comicAuthor = comicAuthor == null ? null : comicAuthor.trim();
    }

    public String getComicCategory() {
        return comicCategory;
    }

    public void setComicCategory(String comicCategory) {
        this.comicCategory = comicCategory == null ? null : comicCategory.trim();
    }

    public String getComicStatus() {
        return comicStatus;
    }

    public void setComicStatus(String comicStatus) {
        this.comicStatus = comicStatus == null ? null : comicStatus.trim();
    }

    public String getComicLabel() {
        return comicLabel;
    }

    public void setComicLabel(String comicLabel) {
        this.comicLabel = comicLabel == null ? null : comicLabel.trim();
    }

    public String getComicHot() {
        return comicHot;
    }

    public void setComicHot(String comicHot) {
        this.comicHot = comicHot == null ? null : comicHot.trim();
    }

    public String getComicPage() {
        return comicPage;
    }

    public void setComicPage(String comicPage) {
        this.comicPage = comicPage == null ? null : comicPage.trim();
    }

    public String getComicTime() {
        return comicTime;
    }

    public void setComicTime(String comicTime) {
        this.comicTime = comicTime == null ? null : comicTime.trim();
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