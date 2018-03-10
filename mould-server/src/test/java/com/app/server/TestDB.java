package com.app.server;

import com.alibaba.fastjson.JSON;
import com.app.core.BaseTranTestCase;
import com.app.server.dao.UserMapper;
import com.app.server.entity.User;
import com.app.server.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDB extends BaseTranTestCase {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testDB() {
        System.out.println("=========================");
        List<User> users = userMapper.selectAll();
        System.out.println(JSON.toJSONString(users));
        System.out.println("=========================");
    }

    @Test
    public void testSearchDB() {
        System.out.println("=========================");
//        User users = userMapper.selectByNameAndPwd("diva","123");
//        System.out.println(JSON.toJSONString(users));

        boolean diva = userService.checkUser("diva", "123");
        System.out.println(diva);
        System.out.println("=========================");
    }
}