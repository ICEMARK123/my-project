package com.kafka.kafka.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author: lihl01
 * @Date: 2019/10/24 5:53 PM
 * @Describe:
 */
public class ProducerClientKafka {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        // 判断是否成功发送了
        properties.put("acks", "all");
        //如果请求失败，请求的次数
        properties.put("retries", 0);
        //（生产者）缓存每个分区未发送的消息
        properties.put("batch.size", 16384);
        //默认立即发送，即使缓存没有满，如果需要发送的数据过多，可以设置时间大于0
        properties.put("linger.ms", 1);
        //生产者可用的缓存总量，如果消息发送速度比传输到服务器的快，会耗尽缓存空间，其他发送调用将会被阻塞，
        // 阻塞时间的阈值通过max.block.ms设定，之后它将抛出一个TimeoutException异常
        properties.put("buffer.memory", 33554432);
        //key.serializer和value.serializer，将用户提供的key和value对象ProducerRecord转换成字节，
        // 你可以用附带的ByteArraySerializer和StringSerializer
        properties.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
        /*Producer<String, String> producer = new KafkaProducer<>(properties);
        for (int i = 0; i < 100; i++) {
            // send 方法是异步的,并且一旦消息被保存在等待发送的消息缓存中，此方法立即返回。
            // 这样并行发送多条消息儿不阻塞去等待每条消息的响应
            producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), Integer.toString(i)));
        }*/
        Producer<byte[], byte[]> producer = new KafkaProducer<>(properties);
        byte[] value = "value".getBytes();
        byte[] key = "key".getBytes();
        ProducerRecord<byte[], byte[]> record = new ProducerRecord<>("my-topic", key, value);
        /*try {
            // 调用get(),将进行阻塞，直到相关请求完成并返回该消息的metadata，或发送抛出异常
            producer.send(record).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        //完全无阻塞，可以利用回调参数提供的请求完成时将调用的回调通知
        producer.send(record, (recordMetadata, e) -> {
            if (e != null) {
                e.printStackTrace();
            }
            System.out.println("The offset of the record we just sent is: " + recordMetadata.offset());
        });



        //消息的回调也是有顺序的，callback1在callback之前
       /* producer.send(new ProducerRecord<byte[],byte[]>(topic, partition, key1, value1), callback1);
        producer.send(new ProducerRecord<byte[],byte[]>(topic, partition, key2, value2), callback2);*/

        producer.close();
    }
}
