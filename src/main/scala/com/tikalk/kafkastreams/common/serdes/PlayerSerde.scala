package com.tikalk.kafkastreams.common.serdes

import java.util

import com.tikalk.kafkastreams.common.model.Player
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}

class PlayerSerde extends Serde[Player]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def serializer(): Serializer[Player] = {
    new JsonSerializer[Player]()
  }

  override def deserializer(): Deserializer[Player] = {
    new PlayerJsonDeserializer()
  }
}
