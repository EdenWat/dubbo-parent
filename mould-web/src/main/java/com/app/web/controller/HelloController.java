package com.app.web.controller;

import com.app.core.BaseController;
import com.app.web.consumer.HelloConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController extends BaseController {
    @Autowired
    private HelloConsumer helloConsumer;

    @PostMapping("hello")
    public Object sayHello(ModelMap modelMap) {
        throw new NullPointerException("kong ce shi yi chang");

//        String sayHello = helloConsumer.sayHello("toms");
//        return getResponse(modelMap, sayHello);
    }
}