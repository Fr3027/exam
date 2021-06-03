package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;

public class Paper implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer courseid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDate date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer count1;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String difficulty1;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer count2;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String difficulty2;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer count3;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String difficulty3;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer count4;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String difficulty4;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalTime starttime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalTime endtime;

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
    public Integer getCourseid() {
        return courseid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTitle() {
        return title;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
    public Integer getUid() {
        return uid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUid(Integer uid) {
        this.uid = uid;
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
    public Integer getCount1() {
        return count1;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCount1(Integer count1) {
        this.count1 = count1;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDifficulty1() {
        return difficulty1;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDifficulty1(String difficulty1) {
        this.difficulty1 = difficulty1 == null ? null : difficulty1.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCount2() {
        return count2;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCount2(Integer count2) {
        this.count2 = count2;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDifficulty2() {
        return difficulty2;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDifficulty2(String difficulty2) {
        this.difficulty2 = difficulty2 == null ? null : difficulty2.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCount3() {
        return count3;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCount3(Integer count3) {
        this.count3 = count3;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDifficulty3() {
        return difficulty3;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDifficulty3(String difficulty3) {
        this.difficulty3 = difficulty3 == null ? null : difficulty3.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getCount4() {
        return count4;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCount4(Integer count4) {
        this.count4 = count4;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDifficulty4() {
        return difficulty4;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDifficulty4(String difficulty4) {
        this.difficulty4 = difficulty4 == null ? null : difficulty4.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalTime getStarttime() {
        return starttime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalTime getEndtime() {
        return endtime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseid=").append(courseid);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", uid=").append(uid);
        sb.append(", date=").append(date);
        sb.append(", count1=").append(count1);
        sb.append(", difficulty1=").append(difficulty1);
        sb.append(", count2=").append(count2);
        sb.append(", difficulty2=").append(difficulty2);
        sb.append(", count3=").append(count3);
        sb.append(", difficulty3=").append(difficulty3);
        sb.append(", count4=").append(count4);
        sb.append(", difficulty4=").append(difficulty4);
        sb.append(", starttime=").append(starttime);
        sb.append(", endtime=").append(endtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}