package com.tikalk.kafkastreams

import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.{ComponentScan, Configuration}


@Configuration
@EnableAutoConfiguration
@ComponentScan
class KafkaStreamsConfig


@SpringBootApplication
object KafkaStreamsMainClass extends App {
    SpringApplication.run(classOf[KafkaStreamsConfig])
}
