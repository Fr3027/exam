package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class Identification implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String grade;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String classname;

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
    public String getGrade() {
        return grade;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getClassname() {
        return classname;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
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
        sb.append(", grade=").append(grade);
        sb.append(", classname=").append(classname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}