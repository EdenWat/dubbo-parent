package com.app.task;

import com.alibaba.fastjson.JSON;
import com.app.core.BaseTranTestCase;
import com.app.core.util.RabbitUtil;
import com.app.task.dao.UserMapper;
import com.app.task.entity.User;
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
        RabbitUtil.send("你好，这是月球！");
        System.out.println("=========================");
    }
}