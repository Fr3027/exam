package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.annotation.Generated;

public class PaperHistory implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer score;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPaperid() {
        return paperid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDate getDate() {
        return date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getScore() {
        return score;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setScore(Integer score) {
        this.score = score;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", paperid=").append(paperid);
        sb.append(", date=").append(date);
        sb.append(", score=").append(score);
        sb.append(", status=").append(status);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}