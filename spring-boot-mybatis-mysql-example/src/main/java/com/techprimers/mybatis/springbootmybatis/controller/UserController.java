package com.techprimers.mybatis.springbootmybatis.controller;

import com.techprimers.mybatis.springbootmybatis.mapper.UserDynamicSqlSupport;
import com.techprimers.mybatis.springbootmybatis.mapper.UserMapper;
import com.techprimers.mybatis.springbootmybatis.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    static QueryExpressionDSL<SelectModel> selectmodel() {
        return select(UserDynamicSqlSupport.user.allColumns()).from(UserDynamicSqlSupport.user);
    }

    SelectStatementProvider buildStatementProvider(QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query) {
        return query.build().render(RenderingStrategies.MYBATIS3);
    }

    @GetMapping("/query/list")
    public List<User> querylist(@RequestParam(required = false) String name, @RequestParam(required = false) String username, @RequestParam(required = false) String password, @RequestParam(required = false) String usertype, @RequestParam(required = false) String major) {

        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(UserDynamicSqlSupport.name, isEqualTo(name).when(Objects::nonNull));
        query = query.and(UserDynamicSqlSupport.username, isEqualTo(username).when(Objects::nonNull));
        query = query.and(UserDynamicSqlSupport.password, isEqualTo(password).when(Objects::nonNull));
        query = query.and(UserDynamicSqlSupport.major, isEqualTo(major).when(Objects::nonNull));
        query = query.and(UserDynamicSqlSupport.usertype, isEqualTo(usertype).when(Objects::nonNull));
        return userMapper.selectMany(this.buildStatementProvider(query));
    }

    @PostMapping(path = "/upsert")
    public String save(@RequestBody User user) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(UserDynamicSqlSupport.username, isEqualTo(user.getUsername()));
        userMapper.selectMany(this.buildStatementProvider(query));
        if (user.getId() == null && !userMapper.selectMany(this.buildStatementProvider(query)).isEmpty())
            return "重复注册";
        //如果ID存在则更新用户，否则插入用户
        if (user.getId() != null) {
            userMapper.updateByPrimaryKeySelective(user);
        } else {
            userMapper.insert(user);
        }
        return "saved";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return "deleted";
    }

    @PostMapping(path = "/login")
    public User login(@RequestBody User user) {
        QueryExpressionDSL<SelectModel>.QueryExpressionWhereBuilder query = this.selectmodel().where(UserDynamicSqlSupport.username, isEqualTo(user.getUsername())).and(UserDynamicSqlSupport.password, isEqualTo(user.getPassword())).and(UserDynamicSqlSupport.usertype, isEqualTo(user.getUsertype()));
        Optional<User> user1 = userMapper.selectOne(this.buildStatementProvider(query));
        if (user1.isPresent())
            return userMapper.selectOne(this.buildStatementProvider(query)).get();
        else return null;
    }
}
