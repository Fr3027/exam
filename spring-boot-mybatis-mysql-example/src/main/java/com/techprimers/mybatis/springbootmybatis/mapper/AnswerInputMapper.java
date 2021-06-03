package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.AnswerInputDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.AnswerInput;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface AnswerInputMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, paperid, uid, questionid, input, title);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<AnswerInput> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AnswerInputResult")
    Optional<AnswerInput> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AnswerInputResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="paperid", property="paperid", jdbcType=JdbcType.INTEGER),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="input", property="input", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<AnswerInput> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AnswerInput record) {
        return MyBatis3Utils.insert(this::insert, record, answerInput, c ->
            c.map(paperid).toProperty("paperid")
            .map(uid).toProperty("uid")
            .map(questionid).toProperty("questionid")
            .map(input).toProperty("input")
            .map(title).toProperty("title")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AnswerInput record) {
        return MyBatis3Utils.insert(this::insert, record, answerInput, c ->
            c.map(paperid).toPropertyWhenPresent("paperid", record::getPaperid)
            .map(uid).toPropertyWhenPresent("uid", record::getUid)
            .map(questionid).toPropertyWhenPresent("questionid", record::getQuestionid)
            .map(input).toPropertyWhenPresent("input", record::getInput)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AnswerInput> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AnswerInput> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<AnswerInput> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<AnswerInput> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, answerInput, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(AnswerInput record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paperid).equalTo(record::getPaperid)
                .set(uid).equalTo(record::getUid)
                .set(questionid).equalTo(record::getQuestionid)
                .set(input).equalTo(record::getInput)
                .set(title).equalTo(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AnswerInput record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paperid).equalToWhenPresent(record::getPaperid)
                .set(uid).equalToWhenPresent(record::getUid)
                .set(questionid).equalToWhenPresent(record::getQuestionid)
                .set(input).equalToWhenPresent(record::getInput)
                .set(title).equalToWhenPresent(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AnswerInput record) {
        return update(c ->
            c.set(paperid).equalTo(record::getPaperid)
            .set(uid).equalTo(record::getUid)
            .set(questionid).equalTo(record::getQuestionid)
            .set(input).equalTo(record::getInput)
            .set(title).equalTo(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AnswerInput record) {
        return update(c ->
            c.set(paperid).equalToWhenPresent(record::getPaperid)
            .set(uid).equalToWhenPresent(record::getUid)
            .set(questionid).equalToWhenPresent(record::getQuestionid)
            .set(input).equalToWhenPresent(record::getInput)
            .set(title).equalToWhenPresent(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }
}