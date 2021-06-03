package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class PaperMap implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer questionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String questiontype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer paperhistoryid;

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
    public Integer getQuestionid() {
        return questionid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getQuestiontype() {
        return questiontype;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype == null ? null : questiontype.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPaperhistoryid() {
        return paperhistoryid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPaperhistoryid(Integer paperhistoryid) {
        this.paperhistoryid = paperhistoryid;
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
        sb.append(", questionid=").append(questionid);
        sb.append(", questiontype=").append(questiontype);
        sb.append(", paperhistoryid=").append(paperhistoryid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}