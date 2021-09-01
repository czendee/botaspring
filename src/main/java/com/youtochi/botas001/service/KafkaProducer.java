package com.youtochi.botas001.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;

@Service
public class KafkaProducer {

  private static final String TOPIC = "students";
  
  @Autowired
  private KafkaTemplate kafkaTemplate;
    
  public void sendMessage(String message) {
    logger.info(String.format("#### -> Producing message -> %s", message));
    this.kafkaTemplate.send(TOPIC, message);
  }
  

}
