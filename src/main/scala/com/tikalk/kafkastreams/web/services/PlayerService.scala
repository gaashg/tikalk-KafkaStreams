package com.tikalk.kafkastreams.web.services

import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.utils.PlayerJsonDeserializer
import com.tikalk.kafkastreams.web.config.PlayerEntitySerde
import javax.annotation.PostConstruct
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.streams.scala.StreamsBuilder
import org.apache.kafka.streams.scala.kstream.{KStream, KTable}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component("playerService")
class PlayerService {
  private val logger: Logger = LoggerFactory.getLogger(classOf[PlayerService])

  import org.apache.kafka.streams.scala.Serdes._
  import org.apache.kafka.streams.scala.ImplicitConversions._

  @PostConstruct
  def start(): Unit = {
    val builder = new StreamsBuilder()
    implicit val playerSerde: Serde[Player] = new PlayerEntitySerde

    val players: KStream[String, Player] = builder.stream[String, Player](Player.TOPIC_NAME)
    val wordCounts = players
      .filter((s, p) => s.length > 10)
      .groupBy((_,word) => word)
      .count()
//    System.out(wordCounts.toString)
    //      .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
    //      .groupBy((_, word) => word)
    //      .count()
    //    wordCounts.toStream.to("streams-wordcount-output")
  }


}
