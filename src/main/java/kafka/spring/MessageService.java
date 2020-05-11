package kafka.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	
	@KafkaListener(topics= "test3", groupId = "group-ms")
	public void onMessage(ConsumerRecord<String, String> message){
		
		System.out.println("-------------------------------");	
		//messages.forEach(message -> { 
			System.out.println("offset: " + message.offset() + " key: " + message.key() + " value:" + message.value());
		//});
	}
}
