package com.lzw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @ProjectName cloud2020
 * @ClassName SendMessageController
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/13 23:04
 * @Version 1.0
 **/
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
      log.info("消费8803，---------->接收到的消息："+message.getPayload()+"\t端口："+serverPort);
    }

}
