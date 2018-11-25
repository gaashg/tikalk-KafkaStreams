package com.tikalk.kafkastreams.streams.quotes

import java.time.Duration
import java.util.Properties

import com.tikalk.kafkastreams.common.utils.GeneralFactory
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsConfig._
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.StreamsBuilder
import org.apache.kafka.streams.scala.kstream.{Consumed, KStream}


object QuotesMain {
/*
  def main(args: Array[String]): Unit = {
    val quotesService = new QuotesService
    quotesService.countQuotesPerSeason("Quotes")
  }
}

class QuotesService {
  def countQuotesPerSeason (streamName : String): Unit ={

    val builder = new StreamsBuilder
    implicit val consumed = Consumed.`with`(Serdes.String(), Serdes.String())
    val objectMapper = GeneralFactory.getObjectMapper()
    val quotesStream : KStream [String, String] = builder.stream[String, String]("Quotes")
    quotesStream//.map((key, event) => (key, GeneralFactory.getObjectMapper().readValue(event, classOf[Quote])))
      .print(Printed.toSysOut[String, String])
//      .filter((key, quote) => !StringUtils.isBlank(quote.episode))
//      .map((key, quote) => (key, quote.episode.toLowerCase))
//      .groupBy((key, episode) => episode)
//      .count()
//      .toStream
//      .through("episodesCount")
//      .print(Printed.toSysOut[String, Long])

    val streams: KafkaStreams = new KafkaStreams(builder.build(), initConfig(streamName))
    streams.start()

    sys.ShutdownHookThread {
      streams.close(Duration.ofSeconds(10))
    }
  }
  */
}
