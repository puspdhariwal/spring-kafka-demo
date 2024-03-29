package kafkademo.config;

import kafkademo.constant.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(AppConstants.LOCATION_TOPIC_NAME).partitions(1).replicas(1).build();
    }

    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME, groupId = "group-1")
    public void readLocation(String message){
        log.info("Location is "+message);

    }
}
