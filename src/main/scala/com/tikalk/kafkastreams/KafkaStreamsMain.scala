package com.tikalk.kafkastreams

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class KafkaStreamsConfig


object KafkaStreamsMain extends App {
    SpringApplication.run(classOf[KafkaStreamsConfig])
}
