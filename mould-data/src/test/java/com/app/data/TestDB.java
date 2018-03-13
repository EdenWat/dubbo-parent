package com.app.data;

import com.alibaba.fastjson.JSON;
import com.app.core.BaseTranTestCase;
import com.app.core.util.RabbitMQUtil;
import com.app.data.dao.UserMapper;
import com.app.data.entity.User;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDB extends BaseTranTestCase {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDB() {
        System.out.println("=========================");
        List<User> users = userMapper.selectAll();
        System.out.println(JSON.toJSONString(users));
        System.out.println("=========================");
    }

    @Test
    public void testMQ() {
        System.out.println("=========================");
        RabbitMQUtil.send("你好，这是地球！");
        System.out.println("=========================");
    }

    @Test
    public void testJodaTime() {
        System.out.println("=========================");
        DateTime parse = DateTime.parse("2018-3-09");
        parse = parse.plusDays(3);
        System.out.println(parse.toString("yyyy-MM-dd"));
        System.out.println("=========================");
    }
}