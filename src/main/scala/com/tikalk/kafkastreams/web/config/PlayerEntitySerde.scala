package com.tikalk.kafkastreams.web.config

import java.util

import com.tikalk.kafkastreams.common.model.{BaseEntity, Player}
import com.tikalk.kafkastreams.common.utils.{JsonSerializer, PlayerJsonDeserializer}
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}

class PlayerEntitySerde extends Serde[Player]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def serializer(): Serializer[Player] = {
    new JsonSerializer[Player]()
  }

  override def deserializer(): Deserializer[Player] = {
    new PlayerJsonDeserializer()
  }
}
