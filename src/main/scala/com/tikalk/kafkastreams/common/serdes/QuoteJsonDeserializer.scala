package com.tikalk.kafkastreams.common.serdes

import com.tikalk.kafkastreams.common.model.{Player, Quote}
import com.tikalk.kafkastreams.common.utils.GeneralFactory

class QuoteJsonDeserializer extends JsonDeserializer[Quote] {

  private val objectMapper = GeneralFactory.getObjectMapper()

  override def deserialize(topic: String, data: Array[Byte]): Quote = {
    objectMapper.readValue(data, classOf[Quote])
  }
}
