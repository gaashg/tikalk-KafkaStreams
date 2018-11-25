package com.tikalk.kafkastreams.common.utils

import com.tikalk.kafkastreams.common.model.Player

class PlayerJsonDeserializer extends JsonDeserializer[Player] {
  override def deserialize(topic: String, data: Array[Byte]): Player = {
    objectMapper.readValue(data,classOf[Player])
  }
}
