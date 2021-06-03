package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PaperDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Paper paper = new Paper();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = paper.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> courseid = paper.courseid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = paper.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = paper.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> uid = paper.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> date = paper.date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> count1 = paper.count1;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> difficulty1 = paper.difficulty1;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> count2 = paper.count2;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> difficulty2 = paper.difficulty2;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> count3 = paper.count3;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> difficulty3 = paper.difficulty3;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> count4 = paper.count4;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> difficulty4 = paper.difficulty4;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalTime> starttime = paper.starttime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalTime> endtime = paper.endtime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Paper extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> courseid = column("courseid", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> uid = column("`uid`", JDBCType.INTEGER);

        public final SqlColumn<LocalDate> date = column("`date`", JDBCType.DATE);

        public final SqlColumn<Integer> count1 = column("count1", JDBCType.INTEGER);

        public final SqlColumn<String> difficulty1 = column("difficulty1", JDBCType.VARCHAR);

        public final SqlColumn<Integer> count2 = column("count2", JDBCType.INTEGER);

        public final SqlColumn<String> difficulty2 = column("difficulty2", JDBCType.VARCHAR);

        public final SqlColumn<Integer> count3 = column("count3", JDBCType.INTEGER);

        public final SqlColumn<String> difficulty3 = column("difficulty3", JDBCType.VARCHAR);

        public final SqlColumn<Integer> count4 = column("count4", JDBCType.INTEGER);

        public final SqlColumn<String> difficulty4 = column("difficulty4", JDBCType.VARCHAR);

        public final SqlColumn<LocalTime> starttime = column("starttime", JDBCType.TIME);

        public final SqlColumn<LocalTime> endtime = column("endtime", JDBCType.TIME);

        public Paper() {
            super("paper");
        }
    }
}