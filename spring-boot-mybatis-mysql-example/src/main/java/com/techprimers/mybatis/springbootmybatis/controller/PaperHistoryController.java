package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.*;
import com.techprimers.mybatis.springbootmybatis.model.Course;
import com.techprimers.mybatis.springbootmybatis.model.Paper;
import com.techprimers.mybatis.springbootmybatis.model.PaperHistory;
import com.techprimers.mybatis.springbootmybatis.model.User;
import com.techprimers.mybatis.springbootmybatis.wrapper.PaperHistoryWrapper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

@RestController
@RequestMapping("/paperhistory")
public class PaperHistoryController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PaperHistoryMapper paperHistoryMapper;
    @Autowired
    private PaperMapper paperMapper;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(PaperHistoryDynamicSqlSupport.paperHistory.allColumns()).from(PaperHistoryDynamicSqlSupport.paperHistory);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/list")
    public List<PaperHistoryWrapper> querylist(@RequestParam(required = false) Integer uid, @RequestParam(required = false) Integer paperid, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam(required = false) Integer score, @RequestParam(required = false) String status) {

        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(PaperHistoryDynamicSqlSupport.uid, isEqualTo(uid).when(Objects::nonNull));
        query = query.and(PaperHistoryDynamicSqlSupport.paperid, isEqualTo(paperid).when(Objects::nonNull));
        query = query.and(PaperHistoryDynamicSqlSupport.date, isEqualTo(date).when(Objects::nonNull));
        query = query.and(PaperHistoryDynamicSqlSupport.score, isEqualTo(score).when(Objects::nonNull));
        query = query.and(PaperHistoryDynamicSqlSupport.status, isEqualTo(status).when(Objects::nonNull));
        List<PaperHistory> paperHistories = paperHistoryMapper.selectMany(this.buildStatementProvider(query));
        List<PaperHistoryWrapper> paperHistoryWrapperList = new ArrayList<>();
        for (PaperHistory paperHistory : paperHistories) {
            Paper paper = paperMapper.selectByPrimaryKey(paperHistory.getPaperid()).get();
            int totalscore = 2 * paper.getCount1() + paper.getCount2() + paper.getCount3() + 5 * paper.getCount4();
            PaperHistoryWrapper paperHistoryWrapper = new PaperHistoryWrapper(paperHistory.getId(), paperHistory.getUid(), paperHistory.getPaperid(), paperHistory.getDate(), paperHistory.getScore(), paperHistory.getStatus(), paperHistory.getTitle(), userMapper.selectByPrimaryKey(paperHistory.getUid()).get().getName(), totalscore);
            paperHistoryWrapperList.add(paperHistoryWrapper);
        }
        return paperHistoryWrapperList;
    }

    @GetMapping(path = "/query/byid")
    public PaperHistory querybyid(@RequestParam Integer id) {
        return paperHistoryMapper.selectByPrimaryKey(id).get();
    }

    @PostMapping(path = "/upsert")
    public String save(@RequestBody PaperHistory paperHistory) {
        paperHistoryMapper.insert(paperHistory);
        return "saved";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        paperHistoryMapper.deleteByPrimaryKey(id);
        return "deleted";
    }

}
