package com.tikalk.kafkastreams.common.kafka

import com.tikalk.kafkastreams.common.model.Quote
import com.tikalk.kafkastreams.common.serdes.JsonSerializer
import javax.annotation.PostConstruct
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.streams.scala.Serdes


class KafkaProducerService[K, V](topicName: String) {

  private var kafkaProducer: KafkaProducer[K, V] = _
  private var topicPartitionsNum: Int = 0

  @PostConstruct
  private def init() = {
    val props = KafkaUtils.initProperties()
    props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Serdes.String.serializer().getClass.getName)
    props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[JsonSerializer[Quote]].getName)

    kafkaProducer = new KafkaProducer[K, V](props)
    topicPartitionsNum = kafkaProducer.partitionsFor(topicName).size()
  }

  def sendMessage(k: K, v: V): Unit = {
    val record = new ProducerRecord[K, V](topicName, KafkaUtils.randomizePartition(topicPartitionsNum), k, v)
    kafkaProducer.send(record).get()
  }
}
