package com.notificationservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String,Object> consumerFactory()
	{
	Map<String,Object> m=new HashMap<String, Object>();
	m.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
	m.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
	m.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
	m.put(ConsumerConfig.GROUP_ID_CONFIG,"loan-group");
	return new DefaultKafkaConsumerFactory<String, Object>(m);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String>  kafkaListenerContainerFactory()
	{
	ConcurrentKafkaListenerContainerFactory<String,String> f=new ConcurrentKafkaListenerContainerFactory<String, String>();
	f.setConsumerFactory(consumerFactory());
	return f;
	} 
	
	

	
}
