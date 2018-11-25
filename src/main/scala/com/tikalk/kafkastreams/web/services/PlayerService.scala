package com.tikalk.kafkastreams.web.services

import com.tikalk.kafkastreams.common.model.Player
import javax.annotation.PostConstruct
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
//    val builder = new StreamsBuilder()
//    val textLines: KStream[String, String] = builder.stream[String, String](Player.TOPIC_NAME)
//    val wordCounts: KTable[String, Long] = textLines
//      .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
//      .groupBy((_, word) => word)
//      .count()
//    wordCounts.toStream.to("streams-wordcount-output")
  }


}
