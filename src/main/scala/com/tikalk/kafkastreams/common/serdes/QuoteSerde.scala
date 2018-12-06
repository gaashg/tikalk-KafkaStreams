package com.tikalk.kafkastreams.common.serdesPlayer

import java.util

import com.tikalk.kafkastreams.common.model.Quote
import com.tikalk.kafkastreams.common.serdes.{JsonSerializer, QuoteJsonDeserializer}
import org.apache.kafka.common.serialization.{Deserializer, Serde, Serializer}

class QuoteSerde extends Serde [Quote]{
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

  override def serializer(): Serializer[Quote] = {
    new JsonSerializer[Quote]()
  }

  override def deserializer(): Deserializer[Quote] = {
    new QuoteJsonDeserializer()
  }
}
