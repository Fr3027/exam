package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.CourseMapper;
import com.techprimers.mybatis.springbootmybatis.mapper.CourseDynamicSqlSupport;
import com.techprimers.mybatis.springbootmybatis.model.Course;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(CourseDynamicSqlSupport.course.allColumns()).from(CourseDynamicSqlSupport.course);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/list")
    public List<Course> querylist(@RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) Integer teacherid) {

        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(CourseDynamicSqlSupport.name, isEqualTo(name).when(Objects::nonNull));
        query = query.and(CourseDynamicSqlSupport.description, isEqualTo(description).when(Objects::nonNull));
        query = query.and(CourseDynamicSqlSupport.teacherid, isEqualTo(teacherid).when(Objects::nonNull));
        return courseMapper.selectMany(this.buildStatementProvider(query));
    }

    @GetMapping(path = "/query/byid")
    public Course querybyid(@RequestParam Integer id) {
        return courseMapper.selectByPrimaryKey(id).get();
    }

    @PostMapping(path = "/upsert")
    public String save(@RequestBody Course course) {
        courseMapper.insert(course);
        return "saved";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        courseMapper.deleteByPrimaryKey(id);
        return "deleted";
    }
}
