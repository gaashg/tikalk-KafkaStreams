package com.tikalk.kafkastreams.common.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.ProducerConfig

import scala.util.Random

object KafkaUtils {
  def initProperties(keySerializerClassName: String, valueSerializerClassName: String) = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializerClassName)
    props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerClassName)

    props
  }

  def randomizePartition(partitionsNum: Int): Int = {
    Random.nextInt(partitionsNum)
  }
}
