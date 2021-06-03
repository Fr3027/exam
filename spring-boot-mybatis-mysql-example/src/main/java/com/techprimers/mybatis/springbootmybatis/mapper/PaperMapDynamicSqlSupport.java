package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PaperMapDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PaperMap paperMap = new PaperMap();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = paperMap.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> paperid = paperMap.paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> questionid = paperMap.questionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> questiontype = paperMap.questiontype;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> paperhistoryid = paperMap.paperhistoryid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PaperMap extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> paperid = column("paperid", JDBCType.INTEGER);

        public final SqlColumn<Integer> questionid = column("questionid", JDBCType.INTEGER);

        public final SqlColumn<String> questiontype = column("questiontype", JDBCType.VARCHAR);

        public final SqlColumn<Integer> paperhistoryid = column("paperhistoryid", JDBCType.INTEGER);

        public PaperMap() {
            super("paper_map");
        }
    }
}