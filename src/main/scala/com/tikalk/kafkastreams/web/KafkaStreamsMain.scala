package com.tikalk.kafkastreams.web

import com.tikalk.kafkastreams.common.config.KafkaStreamsConfig
import org.springframework.boot.SpringApplication

object KafkaStreamsMain extends App {
  SpringApplication.run(classOf[KafkaStreamsConfig])
}
