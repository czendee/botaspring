package com.youtochi.botas001.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;
import java.io.IOException;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;


@Service
public class KafkaConsumer {
//     private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
     
/*     
     @KafkaListener(topics = "students", groupId = "group_id")
     public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        
      }
*/     
    @KafkaListener(topics = "${cloudkarafka.topic}")
    public void consume(String message,
                               @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                               @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                               @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }     
      
}
