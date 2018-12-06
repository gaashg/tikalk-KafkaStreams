package com.tikalk.kafkastreams.common.serdes

import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.utils.GeneralFactory

class PlayerJsonDeserializer extends JsonDeserializer[Player] {

  private val objectMapper = GeneralFactory.getObjectMapper()

  override def deserialize(topic: String, data: Array[Byte]): Player = {
    objectMapper.readValue(data,classOf[Player])
  }
}
