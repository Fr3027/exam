package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.PaperHistoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.PaperHistory;
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
public interface PaperHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, uid, paperid, date, score, status, title);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<PaperHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaperHistoryResult")
    Optional<PaperHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaperHistoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="paperid", property="paperid", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<PaperHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PaperHistory record) {
        return MyBatis3Utils.insert(this::insert, record, paperHistory, c ->
            c.map(uid).toProperty("uid")
            .map(paperid).toProperty("paperid")
            .map(date).toProperty("date")
            .map(score).toProperty("score")
            .map(status).toProperty("status")
            .map(title).toProperty("title")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PaperHistory record) {
        return MyBatis3Utils.insert(this::insert, record, paperHistory, c ->
            c.map(uid).toPropertyWhenPresent("uid", record::getUid)
            .map(paperid).toPropertyWhenPresent("paperid", record::getPaperid)
            .map(date).toPropertyWhenPresent("date", record::getDate)
            .map(score).toPropertyWhenPresent("score", record::getScore)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PaperHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PaperHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PaperHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PaperHistory> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paperHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PaperHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalTo(record::getUid)
                .set(paperid).equalTo(record::getPaperid)
                .set(date).equalTo(record::getDate)
                .set(score).equalTo(record::getScore)
                .set(status).equalTo(record::getStatus)
                .set(title).equalTo(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaperHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalToWhenPresent(record::getUid)
                .set(paperid).equalToWhenPresent(record::getPaperid)
                .set(date).equalToWhenPresent(record::getDate)
                .set(score).equalToWhenPresent(record::getScore)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(title).equalToWhenPresent(record::getTitle);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PaperHistory record) {
        return update(c ->
            c.set(uid).equalTo(record::getUid)
            .set(paperid).equalTo(record::getPaperid)
            .set(date).equalTo(record::getDate)
            .set(score).equalTo(record::getScore)
            .set(status).equalTo(record::getStatus)
            .set(title).equalTo(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PaperHistory record) {
        return update(c ->
            c.set(uid).equalToWhenPresent(record::getUid)
            .set(paperid).equalToWhenPresent(record::getPaperid)
            .set(date).equalToWhenPresent(record::getDate)
            .set(score).equalToWhenPresent(record::getScore)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(title).equalToWhenPresent(record::getTitle)
            .where(id, isEqualTo(record::getId))
        );
    }
}