package com.kafka.kafka.test;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: lihl01
 * @Date: 2019/10/25 8:12 PM
 * @Describe: 多线程处理
 */
public class KafkaConsumerRunner implements Runnable {

    private final AtomicBoolean close = new AtomicBoolean(false);
    private KafkaConsumer consumer;
    @Override
    public void run() {
        try {
            consumer.subscribe(Collections.singletonList("topic"));
            while (!close.get()) {
                ConsumerRecords records = consumer.poll(Duration.ofMillis(1000));
                // todo handle records
            }
        } catch (Exception e) {
            if (!close.get()) {
                throw e;
            }
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        close.set(true);
        //安全地从外部线程来中断活动操作
        consumer.wakeup();
    }
}
