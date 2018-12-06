package com.tikalk.kafkastreams.common.serdes

import java.util

import com.tikalk.kafkastreams.common.model.BaseEntity
import com.tikalk.kafkastreams.common.utils.GeneralFactory
import org.apache.kafka.common.serialization.Serializer

class JsonSerializer[A <: BaseEntity] extends Serializer[A] {
  private val objectMapper = GeneralFactory.getObjectMapper()

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def serialize(topic: String, data: A): Array[Byte] = {
    objectMapper.writeValueAsString(data).getBytes
  }

  override def close(): Unit = {}
}
