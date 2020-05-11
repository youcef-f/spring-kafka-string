package kafka.spring;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class restControl {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@GetMapping("/send/{message}/{topic}")
	public String sendMessage(
			@PathVariable String message,
			@PathVariable String topic)
	{
		 kafkaTemplate.send(topic,String.valueOf(Math.random()*1000),message);
		 return "message sent ..." ; 
	}
	
}
