package com.techprimers.mybatis.springbootmybatis.model;

import java.io.Serializable;
import javax.annotation.Generated;

public class Question implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer courseid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String choicea;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String choiceb;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String choicec;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String choiced;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String answer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String input;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String difficulty;

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
    public Integer getCourseid() {
        return courseid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getType() {
        return type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChoicea() {
        return choicea;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChoicea(String choicea) {
        this.choicea = choicea == null ? null : choicea.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChoiceb() {
        return choiceb;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChoiceb(String choiceb) {
        this.choiceb = choiceb == null ? null : choiceb.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChoicec() {
        return choicec;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChoicec(String choicec) {
        this.choicec = choicec == null ? null : choicec.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChoiced() {
        return choiced;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChoiced(String choiced) {
        this.choiced = choiced == null ? null : choiced.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAnswer() {
        return answer;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
    public String getDifficulty() {
        return difficulty;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
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
        sb.append(", courseid=").append(courseid);
        sb.append(", type=").append(type);
        sb.append(", choicea=").append(choicea);
        sb.append(", choiceb=").append(choiceb);
        sb.append(", choicec=").append(choicec);
        sb.append(", choiced=").append(choiced);
        sb.append(", answer=").append(answer);
        sb.append(", input=").append(input);
        sb.append(", difficulty=").append(difficulty);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}