package com.app.core.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class RabbitMQUtil {
    /**
     * RabbitMQ消息发送和接收模板
     */
    private static RabbitTemplate template;

    @Autowired
    public void setTemplate(RabbitTemplate template) {
        RabbitMQUtil.template = template;
    }

    /**
     * 发送文本消息
     *
     * @param msg 消息内容
     */
    public static void send(String msg) {
        template.convertAndSend(msg);

        if (log.isInfoEnabled())
            log.info("RabbitMQ消息发送成功，消息内容：{}", msg);
    }
}