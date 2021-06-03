package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.QuestionDynamicSqlSupport;
import com.techprimers.mybatis.springbootmybatis.mapper.QuestionMapper;
import com.techprimers.mybatis.springbootmybatis.model.Course;
import com.techprimers.mybatis.springbootmybatis.model.Question;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(QuestionDynamicSqlSupport.question.allColumns()).from(QuestionDynamicSqlSupport.question);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/list")
    public List<Question> querylist(@RequestParam(required = false) Integer courseid, @RequestParam(required = false) String type, @RequestParam(required = false) String choicea, @RequestParam(required = false) String choiceb, @RequestParam(required = false) String choicec, @RequestParam(required = false) String choiced, @RequestParam(required = false) String answer, @RequestParam(required = false) String input) {

        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(QuestionDynamicSqlSupport.courseid, isEqualTo(courseid).when(Objects::nonNull));
        query = query.and(QuestionDynamicSqlSupport.type, isEqualTo(type).when(Objects::nonNull));
        return questionMapper.selectMany(this.buildStatementProvider(query));
    }

    @GetMapping(path = "/query/byid")
    public Question querybyid(@RequestParam Integer id) {
        return questionMapper.selectByPrimaryKey(id).get();
    }

    @PostMapping(path = "/upsert")
    public String save(@RequestBody Question question) {
        //如果ID存在则更新问题，否则插入问题
        if (question.getId() != null) {
            questionMapper.updateByPrimaryKeySelective(question);
        } else {
            questionMapper.insert(question);
        }
        return "saved";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        questionMapper.deleteByPrimaryKey(id);
        return "deleted";
    }
}
