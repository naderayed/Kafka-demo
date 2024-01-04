package com.nader.kafkademo.controllers;

import com.nader.kafkademo.payloads.Student;
import com.nader.kafkademo.producers.KafkaJsonProducer;
import com.nader.kafkademo.producers.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class messageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String msg
    ) {
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message queued ");
    }
    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(
            @RequestBody Student student
    ) {
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Student queued ");
    }
}
