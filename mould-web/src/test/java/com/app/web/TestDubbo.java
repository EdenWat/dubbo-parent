package com.app.web;

import com.app.core.BaseTestCase;
import com.app.web.consumer.HelloConsumer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDubbo extends BaseTestCase {
    @Autowired
    private HelloConsumer helloConsumer;

    @Test
    public void test() {
        System.out.println("==============================");
        String jom = helloConsumer.sayHello("jom");
        System.out.println(jom);
        System.out.println("==============================");
    }
}
