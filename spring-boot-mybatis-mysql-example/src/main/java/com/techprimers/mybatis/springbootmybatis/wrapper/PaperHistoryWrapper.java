package com.techprimers.mybatis.springbootmybatis.wrapper;

import javax.annotation.Generated;
import java.time.LocalDate;

public class PaperHistoryWrapper {
    private Integer id;

    private Integer uid;

    private Integer paperid;

    private LocalDate date;

    private Integer score;

    private String status;

    private String title;

    private String name;

    private Integer totalscore;

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public PaperHistoryWrapper(Integer id, Integer uid, Integer paperid, LocalDate date, Integer score, String status, String title, String name, Integer totalscore) {
        this.id = id;
        this.uid = uid;
        this.paperid = paperid;
        this.date = date;
        this.score = score;
        this.status = status;
        this.title = title;
        this.name = name;
        this.totalscore = totalscore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

}
