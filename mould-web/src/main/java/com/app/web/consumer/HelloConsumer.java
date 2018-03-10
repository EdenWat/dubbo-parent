package com.app.web.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.app.api.provider.HelloProvider;
import org.springframework.stereotype.Service;

@Service
public class HelloConsumer {
    @Reference(version = "1.0")
    private HelloProvider helloProvider;

    public String sayHello(String param) {
        return helloProvider.sayHello(param);
    }
}