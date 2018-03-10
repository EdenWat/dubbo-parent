package com.app.server.listener;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.CharEncoding;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Log4j2
@Component
public class QueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            // 将 byte 数组转换为字符串
            String msgContent = new String(message.getBody(), CharEncoding.UTF_8);

            if (log.isInfoEnabled())
                log.info("RabbitMQ消息接收成功，消息内容：{}", msgContent);
        } catch (UnsupportedEncodingException e) {
            log.error("RabbitMQ编码类型不支持", e);
        }
    }
}