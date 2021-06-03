package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class AnswerInput implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer questionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String input;

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
    public Integer getPaperid() {
        return paperid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
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
    public Integer getQuestionid() {
        return questionid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getInput() {
        return input;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
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
        sb.append(", paperid=").append(paperid);
        sb.append(", uid=").append(uid);
        sb.append(", questionid=").append(questionid);
        sb.append(", input=").append(input);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}