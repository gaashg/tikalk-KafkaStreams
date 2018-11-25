package com.tikalk.kafkastreams.common.serdes

import java.util

import com.tikalk.kafkastreams.common.model.Quote
import org.apache.kafka.common.serialization.Serializer

class QuotesSerializer extends Serializer [Quote]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = ???

  override def serialize(topic: String, data: Quote): Array[Byte] = ???

  override def close(): Unit = ???
}
