package com.app.web.controller;

import com.app.core.BaseController;
import com.app.web.consumer.UserConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    @Autowired
    private UserConsumer userConsumer;

    @PostMapping("login")
    public Object login(ModelMap modelMap, String account, String password) {
        Map<String, Object> map = userConsumer.login(account, password);
        return getResponse(modelMap, map);
    }
}