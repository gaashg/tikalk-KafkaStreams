package com.tikalk.kafkastreams.common.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig}

import scala.util.Random

object KafkaUtils {
  def initProperties() = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")

    props
  }

  def randomizePartition(partitionsNum: Int): Int = {
    Random.nextInt(partitionsNum)
  }
}
