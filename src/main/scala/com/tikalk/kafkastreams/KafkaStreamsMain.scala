package com.tikalk.kafkastreams

import com.tikalk.kafkastreams.config.KafkaStreamsConfig
import org.springframework.boot.SpringApplication


object KafkaStreamsMain extends App {
  SpringApplication.run(classOf[KafkaStreamsConfig])
}
