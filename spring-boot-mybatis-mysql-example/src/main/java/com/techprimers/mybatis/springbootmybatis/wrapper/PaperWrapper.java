package com.techprimers.mybatis.springbootmybatis.wrapper;

import javax.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class PaperWrapper implements Serializable {
    private Integer id;

    private Integer courseid;

    private String title;

    private String description;

    private Integer uid;

    private LocalDate date;

    private Integer count1;

    private String difficulty1;

    private Integer count2;

    private String difficulty2;

    private Integer count3;

    private String difficulty3;

    private Integer count4;

    private String difficulty4;
    private LocalTime starttime;
    private LocalTime endtime;
    private String name;

    public PaperWrapper(Integer id, Integer courseid, String title, String description, Integer uid, LocalDate date, Integer count1, String difficulty1, Integer count2, String difficulty2, Integer count3, String difficulty3, Integer count4, String difficulty4, LocalTime starttime,LocalTime endtime, String name) {
        this.id = id;
        this.courseid = courseid;
        this.title = title;
        this.description = description;
        this.uid = uid;
        this.date = date;
        this.count1 = count1;
        this.difficulty1 = difficulty1;
        this.count2 = count2;
        this.difficulty2 = difficulty2;
        this.count3 = count3;
        this.difficulty3 = difficulty3;
        this.count4 = count4;
        this.difficulty4 = difficulty4;
        this.starttime = starttime;
        this.endtime = endtime;
        this.name = name;
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

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getCount1() {
        return count1;
    }

    public void setCount1(Integer count1) {
        this.count1 = count1;
    }

    public String getDifficulty1() {
        return difficulty1;
    }

    public void setDifficulty1(String difficulty1) {
        this.difficulty1 = difficulty1 == null ? null : difficulty1.trim();
    }

    public Integer getCount2() {
        return count2;
    }

    public void setCount2(Integer count2) {
        this.count2 = count2;
    }

    public String getDifficulty2() {
        return difficulty2;
    }

    public void setDifficulty2(String difficulty2) {
        this.difficulty2 = difficulty2 == null ? null : difficulty2.trim();
    }

    public Integer getCount3() {
        return count3;
    }

    public void setCount3(Integer count3) {
        this.count3 = count3;
    }

    public String getDifficulty3() {
        return difficulty3;
    }

    public void setDifficulty3(String difficulty3) {
        this.difficulty3 = difficulty3 == null ? null : difficulty3.trim();
    }

    public Integer getCount4() {
        return count4;
    }

    public void setCount4(Integer count4) {
        this.count4 = count4;
    }

    public String getDifficulty4() {
        return difficulty4;
    }

    public void setDifficulty4(String difficulty4) {
        this.difficulty4 = difficulty4 == null ? null : difficulty4.trim();
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }
}