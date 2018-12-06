package com.tikalk.kafkastreams.web.services

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.serdes.PlayerSerde
import javax.annotation.PostConstruct
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.StreamsBuilder
import org.apache.kafka.streams.scala.kstream.{KStream, KTable}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("playerService")
class PlayerService {
  private val logger: Logger = LoggerFactory.getLogger(classOf[PlayerService])

  import org.apache.kafka.streams.scala.ImplicitConversions._
  import org.apache.kafka.streams.scala.Serdes._

  @Autowired
  val producerConfig: Properties = null

  @PostConstruct
  def start(): Unit = {


    val builder = new StreamsBuilder()
    implicit val playerSerde: Serde[Player] = new PlayerSerde

//    val players: KStream[String, Player] = builder.stream[String, Player](Player.TOPIC_NAME)
    //    players.print(Printed.toSysOut)

//    val wordCounts = players
//      .filter((s, p) => p.age > 40)
//      .groupBy((_, word) => word.age)
//      .count()
//      .toStream
      //      .foreach()
//            .print(Printed.toSysOut())
//      .to("player-count")

    val playerTables: KTable[String, Player] = builder.table[String, Player](Player.TOPIC_NAME)
    playerTables.toStream
      .print(Printed.toSysOut())
//      .foreach()
    //    val res = playerTables
    //      .filter((s, p) => s.length > 10)
    //
    //    res.toStream.to("player-res")
    val playerStream: KafkaStreams = new KafkaStreams(builder.build(), producerConfig)


    playerStream.cleanUp()
    playerStream.start()

    sys.ShutdownHookThread {
      playerStream.close(120, TimeUnit.SECONDS)
    }


    //    System.out(wordCounts.toString)
    //      .flatMapValues(textLine => textLine.toLowerCase.split("\\W+"))
    //      .groupBy((_, word) => word)
    //      .count()
    //    wordCounts.toStream.to("streams-wordcount-output")
  }


}
