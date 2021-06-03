package com.techprimers.mybatis.springbootmybatis.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AnswerInputDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final AnswerInput answerInput = new AnswerInput();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> id = answerInput.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> paperid = answerInput.paperid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> uid = answerInput.uid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> questionid = answerInput.questionid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> input = answerInput.input;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = answerInput.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class AnswerInput extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> paperid = column("paperid", JDBCType.INTEGER);

        public final SqlColumn<Integer> uid = column("`uid`", JDBCType.INTEGER);

        public final SqlColumn<Integer> questionid = column("questionid", JDBCType.INTEGER);

        public final SqlColumn<String> input = column("`input`", JDBCType.VARCHAR);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public AnswerInput() {
            super("answer_input");
        }
    }
}