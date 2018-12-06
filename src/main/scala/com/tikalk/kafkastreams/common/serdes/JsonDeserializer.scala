package com.tikalk.kafkastreams.common.serdes

import java.util

import com.tikalk.kafkastreams.common.model.BaseEntity
import org.apache.kafka.common.serialization.Deserializer

abstract class JsonDeserializer[A <: BaseEntity] extends Deserializer[A] {
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}
}
