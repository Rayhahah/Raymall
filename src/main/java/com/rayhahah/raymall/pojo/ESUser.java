package com.rayhahah.raymall.pojo;

import java.util.Date;

public class ESUser {
    private Integer id;

    private String username;

    private String password;

    private String screenname;

    private String email;

    private String phone;

    private String cover;

    private String question;

    private String answer;

    private String hupuUsername;

    private String hupuPassword;

    private Date createTime;

    private Date updateTime;

    public ESUser(Integer id, String username, String password, String screenname, String email, String phone, String cover, String question, String answer, String hupuUsername, String hupuPassword, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.screenname = screenname;
        this.email = email;
        this.phone = phone;
        this.cover = cover;
        this.question = question;
        this.answer = answer;
        this.hupuUsername = hupuUsername;
        this.hupuPassword = hupuPassword;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ESUser() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname == null ? null : screenname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getHupuUsername() {
        return hupuUsername;
    }

    public void setHupuUsername(String hupuUsername) {
        this.hupuUsername = hupuUsername == null ? null : hupuUsername.trim();
    }

    public String getHupuPassword() {
        return hupuPassword;
    }

    public void setHupuPassword(String hupuPassword) {
        this.hupuPassword = hupuPassword == null ? null : hupuPassword.trim();
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