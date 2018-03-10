package com.app.web.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.app.api.provider.UserProvider;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserConsumer {
    @Reference(version = "1.0")
    private UserProvider userProvider;

    public Map<String, Object> login(String account, String password) {
        return userProvider.login(account, password);
    }
}