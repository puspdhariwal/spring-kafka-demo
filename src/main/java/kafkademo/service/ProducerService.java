package kafkademo.service;

import kafkademo.constant.AppConstants;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String message){

        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, message);
        return true;

    }
}
