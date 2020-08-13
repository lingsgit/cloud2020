package com.lzw.springcloud.service.impl;

import com.lzw.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ProjectName cloud2020
 * @ClassName MessageProviderImpl
 * @Description TODO
 * @Auther don't you see
 * @Date 2020/8/13 22:58
 * @Version 1.0
 **/
@EnableBinding(Source.class) //定义消息推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("***serial:"+serial);
        return "结束*******";
    }
}
