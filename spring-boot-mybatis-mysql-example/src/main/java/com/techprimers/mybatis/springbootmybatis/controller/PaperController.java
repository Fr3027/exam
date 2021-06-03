package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.*;
import com.techprimers.mybatis.springbootmybatis.model.*;
import com.techprimers.mybatis.springbootmybatis.wrapper.PaperHistoryWrapper;
import com.techprimers.mybatis.springbootmybatis.wrapper.PaperWrapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private PaperHistoryMapper paperHistoryMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private PaperMapMapper paperMapMapper;
    @Autowired
    private AnswerInputMapper answerInputMapper;
    @Autowired
    private UserMapper userMapper;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(PaperDynamicSqlSupport.paper.allColumns()).from(PaperDynamicSqlSupport.paper);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/list")
    public List<Paper> querylist(@RequestParam(required = false) Integer courseid, @RequestParam(required = false) Integer uid, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) LocalDate date) {

        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(PaperDynamicSqlSupport.courseid, isEqualTo(courseid).when(Objects::nonNull));
        query = query.and(PaperDynamicSqlSupport.uid, isEqualTo(uid).when(Objects::nonNull));
        query = query.and(PaperDynamicSqlSupport.date, isEqualTo(date).when(Objects::nonNull));
        return paperMapper.selectMany(this.buildStatementProvider(query));
    }

    //    查询这个学生没做过的试卷
    @GetMapping("/query/available")
    public List<PaperWrapper> queryavailable(@RequestParam Integer uid) {
        QueryExpressionDSL<SelectModel> from = select(PaperHistoryDynamicSqlSupport.paperHistory.paperid).from(PaperHistoryDynamicSqlSupport.paperHistory);
        List<Integer> collect = paperHistoryMapper.selectMany(this.buildStatementProvider(from.where(PaperHistoryDynamicSqlSupport.uid, isEqualTo(uid)))).stream().map(PaperHistory::getPaperid).collect(Collectors.toList());
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(PaperDynamicSqlSupport.id, isNotIn(collect));
    //    限定必须是今天的试卷
        query = query.and(PaperHistoryDynamicSqlSupport.date, isEqualTo(java.time.LocalDate.now()).when(Objects::nonNull));
        List<PaperWrapper> paperWrapperList = new ArrayList<>();
        for (Paper paper : paperMapper.selectMany(this.buildStatementProvider(query))) {
            PaperWrapper historyWrapper = new PaperWrapper(paper.getId(), paper.getCourseid(), paper.getTitle(), paper.getDescription(), paper.getUid(), paper.getDate(), paper.getCount1(), paper.getDifficulty1(), paper.getCount2(), paper.getDifficulty2(), paper.getCount3(), paper.getDifficulty3(), paper.getCount4(), paper.getDifficulty4(), paper.getStarttime(),paper.getEndtime(),userMapper.selectByPrimaryKey(paper.getUid()).get().getName());
            paperWrapperList.add(historyWrapper);
        }
        return paperWrapperList;
    }

    //    根据试卷ID及相关信息自动组卷
    @GetMapping(path = "/generate")
    public Map<String, List<Question>> generate(@RequestParam Integer id) {
        Paper paper = paperMapper.selectByPrimaryKey(id).get();
        //单选题
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = QuestionController.selectmodel().where(QuestionDynamicSqlSupport.courseid, isEqualTo(paper.getCourseid())).and(QuestionDynamicSqlSupport.type, isEqualTo("单选题")).and(QuestionDynamicSqlSupport.difficulty, isEqualTo(paper.getDifficulty1()));
        List<Question> question1 = questionMapper.selectMany(this.buildStatementProvider(query));
        Collections.shuffle(question1);
        question1 = question1.stream().limit(paper.getCount1()).collect(Collectors.toList());
        //填空题
        query = QuestionController.selectmodel().where(QuestionDynamicSqlSupport.courseid, isEqualTo(paper.getCourseid())).and(QuestionDynamicSqlSupport.type, isEqualTo("填空题")).and(QuestionDynamicSqlSupport.difficulty, isEqualTo(paper.getDifficulty2()));
        List<Question> question2 = questionMapper.selectMany(this.buildStatementProvider(query));
        Collections.shuffle(question2);
        question2 = question2.stream().limit(paper.getCount2()).collect(Collectors.toList());
        //判断题
        query = QuestionController.selectmodel().where(QuestionDynamicSqlSupport.courseid, isEqualTo(paper.getCourseid())).and(QuestionDynamicSqlSupport.type, isEqualTo("判断题")).and(QuestionDynamicSqlSupport.difficulty, isEqualTo(paper.getDifficulty3()));
        List<Question> question3 = questionMapper.selectMany(this.buildStatementProvider(query));
        Collections.shuffle(question3);
        question3 = question3.stream().limit(paper.getCount3()).collect(Collectors.toList());
        //主观题
        query = QuestionController.selectmodel().where(QuestionDynamicSqlSupport.courseid, isEqualTo(paper.getCourseid())).and(QuestionDynamicSqlSupport.type, isEqualTo("主观题")).and(QuestionDynamicSqlSupport.difficulty, isEqualTo(paper.getDifficulty4()));
        List<Question> question4 = questionMapper.selectMany(this.buildStatementProvider(query));
        Collections.shuffle(question4);
        question4 = question4.stream().limit(paper.getCount4()).collect(Collectors.toList());
        Map<String, List<Question>> map = new HashMap<>();
        map.put("单选题", question1);
        map.put("填空题", question2);
        map.put("判断题", question3);
        map.put("主观题", question4);
        return map;
    }

    @PostMapping(path = "/submit")
    public String submit(@RequestParam Integer uid, @RequestParam Integer paperid, @RequestBody Iterable<Question> questions) {

        int score = 0;
        for (Question q : questions) {
            //客观题打分
            if (!q.getType().equals("主观题")) {
                //回答正确加分
                if (q.getInput() != null && q.getInput().equals(q.getAnswer())) {
                    switch (q.getType()) {
                        case "单选题":
                            score += 2;
                            break;
                        case "填空题":
                            score += 1;
                            break;
                        case "判断题":
                            score += 1;
                            break;
                        default:
                            // code block
                    }
                }
            } else {
                AnswerInput answerInput = new AnswerInput();
                answerInput.setPaperid(paperid);
                answerInput.setUid(uid);
                answerInput.setQuestionid(q.getId());
                answerInput.setInput(q.getInput());
                answerInput.setTitle(q.getTitle());
                answerInputMapper.insert(answerInput);
            }

        }
        //生成考试记录
        PaperHistory paperHistory = new PaperHistory();
        paperHistory.setPaperid(paperid);
        paperHistory.setUid(uid);
        paperHistory.setScore(score);
        paperHistory.setDate(java.time.LocalDate.now());
        paperHistory.setStatus("待批阅");
        paperHistory.setTitle(paperMapper.selectByPrimaryKey(paperid).get().getTitle());
        paperHistoryMapper.insert(paperHistory);
        //生成papermap
        for (Question q2 : questions) {
            PaperMap paperMap = new PaperMap();
            paperMap.setPaperid(paperid);
            paperMap.setQuestionid(q2.getId());
            paperMap.setQuestiontype(q2.getType());
            paperMap.setPaperhistoryid(paperHistory.getId());
            paperMapMapper.insert(paperMap);
        }
        return "交卷成功！";
    }

    @GetMapping(path = "/score")
    public String score(@RequestParam Integer score, @RequestParam Integer paperhistoryid) {
        PaperHistory paperHistory = paperHistoryMapper.selectByPrimaryKey(paperhistoryid).get();
        paperHistory.setScore(paperHistory.getScore() + score);
        paperHistory.setStatus("已批阅");
        paperHistoryMapper.updateByPrimaryKeySelective(paperHistory);
        return "阅卷完成";
    }

    @GetMapping(path = "/query/byid")
    public Paper querybyid(@RequestParam Integer id) {
        return paperMapper.selectByPrimaryKey(id).get();
    }

    @PostMapping(path = "/upsert")
    public String save(@RequestBody Paper paper) {
        paperMapper.insert(paper);
        return "saved";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        paperMapper.deleteByPrimaryKey(id);
        return "deleted";
    }
    @GetMapping(path = "/downloadexcel")
    public void downloadexcel(@RequestParam Integer paperid,HttpServletResponse response){
        //获取这场考试的成绩
        QueryExpressionDSL<SelectModel> from = select(PaperHistoryDynamicSqlSupport.paperHistory.allColumns()).from(PaperHistoryDynamicSqlSupport.paperHistory);
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = from.where(PaperHistoryDynamicSqlSupport.paperid, isEqualTo(paperid).when(Objects::nonNull));
        List<PaperHistory> paperHistories = paperHistoryMapper.selectMany(this.buildStatementProvider(query));
        List<PaperHistoryWrapper> paperHistoryWrapperList = new ArrayList<>();
        for (PaperHistory paperHistory : paperHistories) {
            Paper paper = paperMapper.selectByPrimaryKey(paperHistory.getPaperid()).get();
            int totalscore = 2 * paper.getCount1() + paper.getCount2() + paper.getCount3() + 5 * paper.getCount4();
            PaperHistoryWrapper paperHistoryWrapper = new PaperHistoryWrapper(paperHistory.getId(), paperHistory.getUid(), paperHistory.getPaperid(), paperHistory.getDate(), paperHistory.getScore(), paperHistory.getStatus(), paperHistory.getTitle(), userMapper.selectByPrimaryKey(paperHistory.getUid()).get().getName(), totalscore);
            paperHistoryWrapperList.add(paperHistoryWrapper);
        }
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(paperMapper.selectByPrimaryKey(paperid).get().getTitle()+"成绩");
        this.writeHeaderLine(sheet);
        int rownum = 1;
        for(PaperHistoryWrapper p:paperHistoryWrapperList){
            Row row = sheet.createRow(rownum++);
            Cell cell = row.createCell(0);
            cell.setCellValue(p.getName());
            cell = row.createCell(1);
            cell.setCellValue(p.getDate().toString());
            cell = row.createCell(2);
            cell.setCellValue(p.getScore());
        }
        try
        {
            File file = new File(paperMapper.selectByPrimaryKey(paperid).get().getTitle() + "成绩");
            downloadFile(file,response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void downloadFile(File file, HttpServletResponse response){

        try {
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("content-disposition", "attachment; filename="+java.net.URLEncoder.encode(file.getName(), "UTF-8")+".xlsx");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            FileInputStream fin = null;
            try {
                fin = new FileInputStream(file);
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            final int size = 1024;
            try {
                response.setContentLength(fin.available());
                final byte[] buffer = new byte[size];
                ServletOutputStream outputStream = null;

                outputStream = response.getOutputStream();
                int length = 0;
                while ((length = fin.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }
                fin.close();
                outputStream.flush();
                outputStream.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }catch (final Exception ex){
            ex.printStackTrace();
        }

    }
    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("姓名");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("考试时间");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("得分");
    }
}
