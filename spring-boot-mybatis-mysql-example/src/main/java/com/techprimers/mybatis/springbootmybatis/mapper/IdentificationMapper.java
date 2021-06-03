package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.IdentificationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.Identification;
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
public interface IdentificationMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, uid, grade, classname);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Identification> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("IdentificationResult")
    Optional<Identification> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="IdentificationResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="grade", property="grade", jdbcType=JdbcType.VARCHAR),
        @Result(column="classname", property="classname", jdbcType=JdbcType.VARCHAR)
    })
    List<Identification> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Identification record) {
        return MyBatis3Utils.insert(this::insert, record, identification, c ->
            c.map(uid).toProperty("uid")
            .map(grade).toProperty("grade")
            .map(classname).toProperty("classname")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Identification record) {
        return MyBatis3Utils.insert(this::insert, record, identification, c ->
            c.map(uid).toPropertyWhenPresent("uid", record::getUid)
            .map(grade).toPropertyWhenPresent("grade", record::getGrade)
            .map(classname).toPropertyWhenPresent("classname", record::getClassname)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Identification> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Identification> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Identification> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Identification> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, identification, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Identification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalTo(record::getUid)
                .set(grade).equalTo(record::getGrade)
                .set(classname).equalTo(record::getClassname);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Identification record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uid).equalToWhenPresent(record::getUid)
                .set(grade).equalToWhenPresent(record::getGrade)
                .set(classname).equalToWhenPresent(record::getClassname);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Identification record) {
        return update(c ->
            c.set(uid).equalTo(record::getUid)
            .set(grade).equalTo(record::getGrade)
            .set(classname).equalTo(record::getClassname)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Identification record) {
        return update(c ->
            c.set(uid).equalToWhenPresent(record::getUid)
            .set(grade).equalToWhenPresent(record::getGrade)
            .set(classname).equalToWhenPresent(record::getClassname)
            .where(id, isEqualTo(record::getId))
        );
    }
}