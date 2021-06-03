package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.*;
import com.techprimers.mybatis.springbootmybatis.model.AnswerInput;
import com.techprimers.mybatis.springbootmybatis.model.PaperHistory;
import com.techprimers.mybatis.springbootmybatis.model.PaperMap;
import com.techprimers.mybatis.springbootmybatis.model.Question;
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
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@RestController
@RequestMapping("/papermap")
public class PaperMapController {
    @Autowired
    private PaperMapMapper paperMapMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerInputMapper answerInputMapper;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(PaperMapDynamicSqlSupport.paperMap.allColumns()).from(PaperMapDynamicSqlSupport.paperMap);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/subjective")
    public List<AnswerInput> querysubjective(@RequestParam Integer paperhistoryid) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(PaperMapDynamicSqlSupport.paperhistoryid, isEqualTo(paperhistoryid));
        query = query.and(PaperMapDynamicSqlSupport.questiontype, isEqualTo("主观题").when(Objects::nonNull));
        List<Integer> collect = paperMapMapper.selectMany(this.buildStatementProvider(query)).stream().map(PaperMap::getQuestionid).collect(Collectors.toList());
        QueryExpressionDSL<SelectModel> from = select(AnswerInputDynamicSqlSupport.answerInput.allColumns()).from(AnswerInputDynamicSqlSupport.answerInput);
        query = from.where(AnswerInputDynamicSqlSupport.questionid, isIn(collect));
        return answerInputMapper.selectMany(buildStatementProvider(query));
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        paperMapMapper.deleteByPrimaryKey(id);
        return "deleted";
    }
}
