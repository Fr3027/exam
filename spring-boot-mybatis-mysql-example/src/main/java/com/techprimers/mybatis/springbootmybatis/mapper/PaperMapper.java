package com.techprimers.mybatis.springbootmybatis.mapper;

import static com.techprimers.mybatis.springbootmybatis.mapper.PaperDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.techprimers.mybatis.springbootmybatis.model.Paper;
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
public interface PaperMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, courseid, title, description, uid, date, count1, difficulty1, count2, difficulty2, count3, difficulty3, count4, difficulty4, starttime, endtime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="record.id", before=false, resultType=Integer.class)
    int insert(InsertStatementProvider<Paper> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaperResult")
    Optional<Paper> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaperResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="courseid", property="courseid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="date", property="date", jdbcType=JdbcType.DATE),
        @Result(column="count1", property="count1", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty1", property="difficulty1", jdbcType=JdbcType.VARCHAR),
        @Result(column="count2", property="count2", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty2", property="difficulty2", jdbcType=JdbcType.VARCHAR),
        @Result(column="count3", property="count3", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty3", property="difficulty3", jdbcType=JdbcType.VARCHAR),
        @Result(column="count4", property="count4", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty4", property="difficulty4", jdbcType=JdbcType.VARCHAR),
        @Result(column="starttime", property="starttime", jdbcType=JdbcType.TIME),
        @Result(column="endtime", property="endtime", jdbcType=JdbcType.TIME)
    })
    List<Paper> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Paper record) {
        return MyBatis3Utils.insert(this::insert, record, paper, c ->
            c.map(courseid).toProperty("courseid")
            .map(title).toProperty("title")
            .map(description).toProperty("description")
            .map(uid).toProperty("uid")
            .map(date).toProperty("date")
            .map(count1).toProperty("count1")
            .map(difficulty1).toProperty("difficulty1")
            .map(count2).toProperty("count2")
            .map(difficulty2).toProperty("difficulty2")
            .map(count3).toProperty("count3")
            .map(difficulty3).toProperty("difficulty3")
            .map(count4).toProperty("count4")
            .map(difficulty4).toProperty("difficulty4")
            .map(starttime).toProperty("starttime")
            .map(endtime).toProperty("endtime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Paper record) {
        return MyBatis3Utils.insert(this::insert, record, paper, c ->
            c.map(courseid).toPropertyWhenPresent("courseid", record::getCourseid)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(uid).toPropertyWhenPresent("uid", record::getUid)
            .map(date).toPropertyWhenPresent("date", record::getDate)
            .map(count1).toPropertyWhenPresent("count1", record::getCount1)
            .map(difficulty1).toPropertyWhenPresent("difficulty1", record::getDifficulty1)
            .map(count2).toPropertyWhenPresent("count2", record::getCount2)
            .map(difficulty2).toPropertyWhenPresent("difficulty2", record::getDifficulty2)
            .map(count3).toPropertyWhenPresent("count3", record::getCount3)
            .map(difficulty3).toPropertyWhenPresent("difficulty3", record::getDifficulty3)
            .map(count4).toPropertyWhenPresent("count4", record::getCount4)
            .map(difficulty4).toPropertyWhenPresent("difficulty4", record::getDifficulty4)
            .map(starttime).toPropertyWhenPresent("starttime", record::getStarttime)
            .map(endtime).toPropertyWhenPresent("endtime", record::getEndtime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Paper> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Paper> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Paper> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Paper> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paper, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Paper record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(courseid).equalTo(record::getCourseid)
                .set(title).equalTo(record::getTitle)
                .set(description).equalTo(record::getDescription)
                .set(uid).equalTo(record::getUid)
                .set(date).equalTo(record::getDate)
                .set(count1).equalTo(record::getCount1)
                .set(difficulty1).equalTo(record::getDifficulty1)
                .set(count2).equalTo(record::getCount2)
                .set(difficulty2).equalTo(record::getDifficulty2)
                .set(count3).equalTo(record::getCount3)
                .set(difficulty3).equalTo(record::getDifficulty3)
                .set(count4).equalTo(record::getCount4)
                .set(difficulty4).equalTo(record::getDifficulty4)
                .set(starttime).equalTo(record::getStarttime)
                .set(endtime).equalTo(record::getEndtime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Paper record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(courseid).equalToWhenPresent(record::getCourseid)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(uid).equalToWhenPresent(record::getUid)
                .set(date).equalToWhenPresent(record::getDate)
                .set(count1).equalToWhenPresent(record::getCount1)
                .set(difficulty1).equalToWhenPresent(record::getDifficulty1)
                .set(count2).equalToWhenPresent(record::getCount2)
                .set(difficulty2).equalToWhenPresent(record::getDifficulty2)
                .set(count3).equalToWhenPresent(record::getCount3)
                .set(difficulty3).equalToWhenPresent(record::getDifficulty3)
                .set(count4).equalToWhenPresent(record::getCount4)
                .set(difficulty4).equalToWhenPresent(record::getDifficulty4)
                .set(starttime).equalToWhenPresent(record::getStarttime)
                .set(endtime).equalToWhenPresent(record::getEndtime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Paper record) {
        return update(c ->
            c.set(courseid).equalTo(record::getCourseid)
            .set(title).equalTo(record::getTitle)
            .set(description).equalTo(record::getDescription)
            .set(uid).equalTo(record::getUid)
            .set(date).equalTo(record::getDate)
            .set(count1).equalTo(record::getCount1)
            .set(difficulty1).equalTo(record::getDifficulty1)
            .set(count2).equalTo(record::getCount2)
            .set(difficulty2).equalTo(record::getDifficulty2)
            .set(count3).equalTo(record::getCount3)
            .set(difficulty3).equalTo(record::getDifficulty3)
            .set(count4).equalTo(record::getCount4)
            .set(difficulty4).equalTo(record::getDifficulty4)
            .set(starttime).equalTo(record::getStarttime)
            .set(endtime).equalTo(record::getEndtime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Paper record) {
        return update(c ->
            c.set(courseid).equalToWhenPresent(record::getCourseid)
            .set(title).equalToWhenPresent(record::getTitle)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(uid).equalToWhenPresent(record::getUid)
            .set(date).equalToWhenPresent(record::getDate)
            .set(count1).equalToWhenPresent(record::getCount1)
            .set(difficulty1).equalToWhenPresent(record::getDifficulty1)
            .set(count2).equalToWhenPresent(record::getCount2)
            .set(difficulty2).equalToWhenPresent(record::getDifficulty2)
            .set(count3).equalToWhenPresent(record::getCount3)
            .set(difficulty3).equalToWhenPresent(record::getDifficulty3)
            .set(count4).equalToWhenPresent(record::getCount4)
            .set(difficulty4).equalToWhenPresent(record::getDifficulty4)
            .set(starttime).equalToWhenPresent(record::getStarttime)
            .set(endtime).equalToWhenPresent(record::getEndtime)
            .where(id, isEqualTo(record::getId))
        );
    }
}