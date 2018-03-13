package com.app.core.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

@Log4j2
public class ActiveMQUtil {
    /**
     * Spring JMS Topic 操作模板
     */
    private static JmsTemplate jmsTopicTemplate;
    /**
     * Spring JMS Queue 操作模板
     */
    private static JmsTemplate jmsQueueTemplate;

    @Autowired
    @Qualifier("jmsTopicTemplate")
    public void setJmsTopicTemplate(JmsTemplate jmsTopicTemplate) {
        ActiveMQUtil.jmsTopicTemplate = jmsTopicTemplate;
    }

    @Autowired
    @Qualifier("jmsQueueTemplate")
    public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
        ActiveMQUtil.jmsQueueTemplate = jmsQueueTemplate;
    }

    public static JmsTemplate getJmsTopicTemplate() {
        return jmsTopicTemplate;
    }

    public static JmsTemplate getJmsQueueTemplate() {
        return jmsQueueTemplate;
    }

    /**
     * 发送JMS Topic消息，使用默认目的地
     *
     * @param message
     */
    public static void sendTopicMessage(Object message) {
        try {
            jmsTopicTemplate.convertAndSend(message);
        } catch (Exception e) {
            log.error("发送JMS Topic消息失败", e);
        }
    }

    /**
     * 发送JMS Topic消息
     *
     * @param destinationName
     * @param message
     */
    public static void sendTopicMessage(String destinationName, final Object message) {
        try {
            jmsTopicTemplate.convertAndSend(destinationName, message);
        } catch (Exception e) {
            log.error("发送JMS Topic消息失败", e);
        }
    }

    /**
     * 发送JMS Topic消息
     *
     * @param destination
     * @param message
     */
    public static void sendTopicMessage(Destination destination, final Object message) {
        try {
            jmsTopicTemplate.convertAndSend(destination, message);
        } catch (Exception e) {
            log.error("发送JMS Topic消息失败", e);
        }
    }

    /**
     * 发送JMS Queue消息，使用默认目的地
     *
     * @param message
     */
    public static void sendQueueMessage(Object message) {
        try {
            jmsQueueTemplate.convertAndSend(message);
        } catch (Exception e) {
            log.error("发送JMS Queue消息失败", e);
        }
    }

    /**
     * 发送JMS Queue消息
     *
     * @param destinationName
     * @param message
     */
    public static void sendQueueMessage(String destinationName, final Object message) {
        try {
            jmsQueueTemplate.convertAndSend(destinationName, message);
        } catch (Exception e) {
            log.error("发送JMS Queue消息失败", e);
        }
    }

    /**
     * 发送JMS Queue消息
     *
     * @param destination
     * @param message
     */
    public static void sendQueueMessage(Destination destination, final Object message) {
        try {
            jmsQueueTemplate.convertAndSend(destination, message);
        } catch (Exception e) {
            log.error("发送JMS Queue消息失败", e);
        }
    }
}