package com.tikalk.kafkastreams.common.utils

import java.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.tikalk.kafkastreams.common.model.BaseEntity
import org.apache.kafka.common.serialization.Deserializer

abstract class JsonDeserializer[A <: BaseEntity] extends Deserializer[A] {
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  def objectMapper(): ObjectMapper = {
    val objectMapper = new ObjectMapper()
    objectMapper.registerModule(DefaultScalaModule)
    import com.fasterxml.jackson.databind.DeserializationFeature
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    objectMapper
  }

  override def close(): Unit = {}

}
