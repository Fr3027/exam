package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class IdentificationDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Identification identification = new Identification();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = identification.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> uid = identification.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> grade = identification.grade;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> classname = identification.classname;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Identification extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> uid = column("`uid`", JDBCType.INTEGER);

        public final SqlColumn<String> grade = column("grade", JDBCType.VARCHAR);

        public final SqlColumn<String> classname = column("classname", JDBCType.VARCHAR);

        public Identification() {
            super("identification");
        }
    }
}