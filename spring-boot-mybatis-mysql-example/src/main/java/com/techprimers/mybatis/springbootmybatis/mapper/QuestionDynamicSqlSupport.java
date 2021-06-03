package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class QuestionDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Question question = new Question();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = question.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> courseid = question.courseid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> type = question.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> choicea = question.choicea;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> choiceb = question.choiceb;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> choicec = question.choicec;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> choiced = question.choiced;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> answer = question.answer;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> input = question.input;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> difficulty = question.difficulty;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = question.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Question extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> courseid = column("courseid", JDBCType.INTEGER);

        public final SqlColumn<String> type = column("`type`", JDBCType.VARCHAR);

        public final SqlColumn<String> choicea = column("choicea", JDBCType.VARCHAR);

        public final SqlColumn<String> choiceb = column("choiceb", JDBCType.VARCHAR);

        public final SqlColumn<String> choicec = column("choicec", JDBCType.VARCHAR);

        public final SqlColumn<String> choiced = column("choiced", JDBCType.VARCHAR);

        public final SqlColumn<String> answer = column("answer", JDBCType.VARCHAR);

        public final SqlColumn<String> input = column("`input`", JDBCType.VARCHAR);

        public final SqlColumn<String> difficulty = column("difficulty", JDBCType.VARCHAR);

        public final SqlColumn<String> title = column("title", JDBCType.LONGVARCHAR);

        public Question() {
            super("question");
        }
    }
}