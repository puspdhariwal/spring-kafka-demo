package kafkademo.controller;


import kafkademo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class KafkaController {
    private final ProducerService producerService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        producerService.updateLocation("("+Math.random()*100+" , "+Math.random()+")");
        return new ResponseEntity<>(Map.of("message","location updated"), HttpStatus.OK);
    }

}
