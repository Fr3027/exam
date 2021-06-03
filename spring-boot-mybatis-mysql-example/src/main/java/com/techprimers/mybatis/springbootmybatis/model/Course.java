package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class Course implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer teacherid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String teachername;

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
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTeacherid() {
        return teacherid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTeachername() {
        return teachername;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", description=").append(description);
        sb.append(", teacherid=").append(teacherid);
        sb.append(", teachername=").append(teachername);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}