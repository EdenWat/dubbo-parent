package com.app.server.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.app.api.provider.HelloProvider;

@Service(version = "1.0")
public class HelloProviderImpl implements HelloProvider {

    public String sayHello(String param) {
        return "Hello " + param + " !";
    }
}