package com.kafka.kafka.test;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: lihl01
 * @Date: 2019/10/25 11:28 AM
 * @Describe:
 */
public class ConsumerClientKafka {

    public static void main(String[] args) {

        //自动提交offset
      /*  Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "false");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Arrays.asList("foo", "bar"));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("输出： offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }*/


        Properties props = new Properties();
        // 连接
        props.put("bootstrap.servers", "localhost:9092");
        //连接的组id
        props.put("group.id" , "test");
        // 是否自动提交
        props.put("enable.auto.commit" , "false");
        // 自动提交间隔
        props.put("auto.commit.interval.ms" , "1000");
        // 心跳超时时间
        props.put("session.timeout.ms" , "30000");
        props.put("key.deserializer" , "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer" , "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<> (props);

        //消费指定分区
        String topic = "foo";
        TopicPartition token1 = new TopicPartition(topic, 0);
        TopicPartition token2 = new TopicPartition(topic, 1);
        consumer.assign(Arrays.asList(token1, token2));

        //指定新的消费位置
        consumer.seek(token1, 100);

        //查找服务器保留的最早和最新的offset的特殊的方法
        consumer.seekToBeginning(Collections.singletonList(token1));
        consumer.seekToEnd(Collections.singletonList(token1));

        //暂停消费指定分区
        consumer.pause(Collections.singletonList(token1));
        //开始指定消费分区
        consumer.resume(Collections.singletonList(token1));
        AtomicBoolean token = new AtomicBoolean(false);
        //临时缓存
        List<ConsumerRecord<String, String> > buffer = new ArrayList<>();
        final long time = 200;
        //订阅
        consumer.subscribe(Arrays.asList("foo", "bar"));
      /*  while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                //将返回的对象添加到缓存中
                buffer.add(record);
            }
            // 消息达到一定的数量，批量处理，处理完提交
            if (buffer.size() >= time) {
                insertInfoData(buffer);
                consumer.commitSync();
                buffer.clear();
            }

        }*/

      //处理完每个分区的消息，提交偏移量
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(Long.MAX_VALUE));
                records.partitions().forEach(partition->{
                    List<ConsumerRecord<String, String>> records1 = records.records(partition);
                    records1.forEach(action -> System.out.println(action.offset() + ": " + action.value()));
                    long offset = records1.get(records1.size() - 1).offset();
                    //提交下偏移量是读取下一个消息的偏移量，因此提交的偏移量加1
                    consumer.commitSync(Collections.singletonMap(partition, new OffsetAndMetadata(offset + 1)));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    private static void insertInfoData(List<ConsumerRecord<String,String>> buffer) {

    }
}
