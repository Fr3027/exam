package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import java.time.LocalDate;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PaperHistoryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PaperHistory paperHistory = new PaperHistory();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = paperHistory.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> uid = paperHistory.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> paperid = paperHistory.paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDate> date = paperHistory.date;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> score = paperHistory.score;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> status = paperHistory.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = paperHistory.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PaperHistory extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> uid = column("`uid`", JDBCType.INTEGER);

        public final SqlColumn<Integer> paperid = column("paperid", JDBCType.INTEGER);

        public final SqlColumn<LocalDate> date = column("`date`", JDBCType.DATE);

        public final SqlColumn<Integer> score = column("score", JDBCType.INTEGER);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public PaperHistory() {
            super("paper_history");
        }
    }
}