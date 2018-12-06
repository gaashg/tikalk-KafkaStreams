package com.tikalk.kafkastreams.common.kafka

import javax.annotation.PostConstruct
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}


class KafkaProducerService[K, V](topicName: String, keySerializerClassName : String, valueSerializerClassName : String) {

  private var kafkaProducer: KafkaProducer[K, V] = _
  private var topicPartitionsNum: Int = 0

  @PostConstruct
  private def init() = {
    val props = KafkaUtils.initProperties(keySerializerClassName, valueSerializerClassName)

    kafkaProducer = new KafkaProducer[K, V](props)
    topicPartitionsNum = kafkaProducer.partitionsFor(topicName).size()
  }

  def sendMessage(k: K, v: V): Unit = {
    val record = new ProducerRecord[K, V](topicName, KafkaUtils.randomizePartition(topicPartitionsNum), k, v)
    kafkaProducer.send(record).get()
  }
}
