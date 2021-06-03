package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.QuestionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.Question;
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
public interface QuestionMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, courseid, type, choicea, choiceb, choicec, choiced, answer, input, difficulty, title);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Question> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("QuestionResult")
    Optional<Question> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="QuestionResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="courseid", property="courseid", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="choicea", property="choicea", jdbcType=JdbcType.VARCHAR),
        @Result(column="choiceb", property="choiceb", jdbcType=JdbcType.VARCHAR),
        @Result(column="choicec", property="choicec", jdbcType=JdbcType.VARCHAR),
        @Result(column="choiced", property="choiced", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="input", property="input", jdbcType=JdbcType.VARCHAR),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Question> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Question record) {
        return MyBatis3Utils.insert(this::insert, record, question, c ->
            c.map(courseid).toProperty("courseid")
            .map(type).toProperty("type")
            .map(choicea).toProperty("choicea")
            .map(choiceb).toProperty("choiceb")
            .map(choicec).toProperty("choicec")
            .map(choiced).toProperty("choiced")
            .map(answer).toProperty("answer")
            .map(input).toProperty("input")
            .map(difficulty).toProperty("difficulty")
            .map(title).toProperty("title")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Question record) {
        return MyBatis3Utils.insert(this::insert, record, question, c ->
            c.map(courseid).toPropertyWhenPresent("courseid", record::getCourseid)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(choicea).toPropertyWhenPresent("choicea", record::getChoicea)
            .map(choiceb).toPropertyWhenPresent("choiceb", record::getChoiceb)
            .map(choicec).toPropertyWhenPresent("choicec", record::getChoicec)
            .map(choiced).toPropertyWhenPresent("choiced", record::getChoiced)
            .map(answer).toPropertyWhenPresent("answer", record::getAnswer)
            .map(input).toPropertyWhenPresent("input", record::getInput)
            .map(difficulty).toPropertyWhenPresent("difficulty", record::getDifficulty)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Question> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Question> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Question> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Question> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, question, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Question record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(courseid).equalTo(record::getCourseid)
                .set(type).equalTo(record::getType)
                .set(choicea).equalTo(record::getChoicea)
                .set(choiceb).equalTo(record::getChoiceb)
                .set(choicec).equalTo(record::getChoicec)
                .set(choiced).equalTo(record::getChoiced)
                .set(answer).equalTo(record::getAnswer)
                .set(input).equalTo(record::getInput)
                .set(difficulty).equalTo(record::getDifficulty)
                .set(title).equalTo(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Question record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(courseid).equalToWhenPresent(record::getCourseid)
                .set(type).equalToWhenPresent(record::getType)
                .set(choicea).equalToWhenPresent(record::getChoicea)
                .set(choiceb).equalToWhenPresent(record::getChoiceb)
                .set(choicec).equalToWhenPresent(record::getChoicec)
                .set(choiced).equalToWhenPresent(record::getChoiced)
                .set(answer).equalToWhenPresent(record::getAnswer)
                .set(input).equalToWhenPresent(record::getInput)
                .set(difficulty).equalToWhenPresent(record::getDifficulty)
                .set(title).equalToWhenPresent(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Question record) {
        return update(c ->
            c.set(courseid).equalTo(record::getCourseid)
            .set(type).equalTo(record::getType)
            .set(choicea).equalTo(record::getChoicea)
            .set(choiceb).equalTo(record::getChoiceb)
            .set(choicec).equalTo(record::getChoicec)
            .set(choiced).equalTo(record::getChoiced)
            .set(answer).equalTo(record::getAnswer)
            .set(input).equalTo(record::getInput)
            .set(difficulty).equalTo(record::getDifficulty)
            .set(title).equalTo(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Question record) {
        return update(c ->
            c.set(courseid).equalToWhenPresent(record::getCourseid)
            .set(type).equalToWhenPresent(record::getType)
            .set(choicea).equalToWhenPresent(record::getChoicea)
            .set(choiceb).equalToWhenPresent(record::getChoiceb)
            .set(choicec).equalToWhenPresent(record::getChoicec)
            .set(choiced).equalToWhenPresent(record::getChoiced)
            .set(answer).equalToWhenPresent(record::getAnswer)
            .set(input).equalToWhenPresent(record::getInput)
            .set(difficulty).equalToWhenPresent(record::getDifficulty)
            .set(title).equalToWhenPresent(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }
}