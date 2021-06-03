package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.PaperMapDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.PaperMap;
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
public interface PaperMapMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, paperid, questionid, questiontype, paperhistoryid);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<PaperMap> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaperMapResult")
    Optional<PaperMap> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaperMapResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="paperid", property="paperid", jdbcType=JdbcType.INTEGER),
        @Result(column="questionid", property="questionid", jdbcType=JdbcType.INTEGER),
        @Result(column="questiontype", property="questiontype", jdbcType=JdbcType.VARCHAR),
        @Result(column="paperhistoryid", property="paperhistoryid", jdbcType=JdbcType.INTEGER)
    })
    List<PaperMap> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PaperMap record) {
        return MyBatis3Utils.insert(this::insert, record, paperMap, c ->
            c.map(paperid).toProperty("paperid")
            .map(questionid).toProperty("questionid")
            .map(questiontype).toProperty("questiontype")
            .map(paperhistoryid).toProperty("paperhistoryid")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PaperMap record) {
        return MyBatis3Utils.insert(this::insert, record, paperMap, c ->
            c.map(paperid).toPropertyWhenPresent("paperid", record::getPaperid)
            .map(questionid).toPropertyWhenPresent("questionid", record::getQuestionid)
            .map(questiontype).toPropertyWhenPresent("questiontype", record::getQuestiontype)
            .map(paperhistoryid).toPropertyWhenPresent("paperhistoryid", record::getPaperhistoryid)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PaperMap> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PaperMap> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PaperMap> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PaperMap> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paperMap, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PaperMap record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paperid).equalTo(record::getPaperid)
                .set(questionid).equalTo(record::getQuestionid)
                .set(questiontype).equalTo(record::getQuestiontype)
                .set(paperhistoryid).equalTo(record::getPaperhistoryid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaperMap record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(paperid).equalToWhenPresent(record::getPaperid)
                .set(questionid).equalToWhenPresent(record::getQuestionid)
                .set(questiontype).equalToWhenPresent(record::getQuestiontype)
                .set(paperhistoryid).equalToWhenPresent(record::getPaperhistoryid);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PaperMap record) {
        return update(c ->
            c.set(paperid).equalTo(record::getPaperid)
            .set(questionid).equalTo(record::getQuestionid)
            .set(questiontype).equalTo(record::getQuestiontype)
            .set(paperhistoryid).equalTo(record::getPaperhistoryid)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PaperMap record) {
        return update(c ->
            c.set(paperid).equalToWhenPresent(record::getPaperid)
            .set(questionid).equalToWhenPresent(record::getQuestionid)
            .set(questiontype).equalToWhenPresent(record::getQuestiontype)
            .set(paperhistoryid).equalToWhenPresent(record::getPaperhistoryid)
            .where(id, isEqualTo(record::getId))
        );
    }
}