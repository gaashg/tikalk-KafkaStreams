package com.tikalk.kafkastreams.streams.statistics

import java.time.Duration

import com.fasterxml.jackson.databind.ObjectMapper
import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.streams.utils.StreamsUtils
import com.tikalk.kafkastreams.web.config.PlayerEntitySerde
import javax.annotation.{PostConstruct, Resource}
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.kstream.{Consumed, Grouped, Materialized, Produced}
import org.apache.kafka.streams.scala.{ByteArrayKeyValueStore, Serdes, StreamsBuilder}
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

import scala.collection.{immutable, mutable}


@Service
class StatisticsStreamsService {
  private val logger = LoggerFactory.getLogger(classOf[StatisticsStreamsService])
  private var _agesMap = Map[Int, Long]()

  @Resource
  private var objectMapper: ObjectMapper = null

  def agesMap = _agesMap

  @PostConstruct
  def stats() = {
    countPlayersAge()
  }

  def countPlayersAge(): Unit = {
    logger.info("Counting players' age")

    val props = StreamsUtils.initProperties()
    implicit val stringSerde = Serdes.String
    implicit val intSerde = Serdes.Integer
    implicit val longSerde = Serdes.Long
    implicit val playerSerde: Serde[Player] = new PlayerEntitySerde
    implicit val consumedStringSerdes = Consumed.`with`(Serdes.String, playerSerde)
    implicit val groupedIntsSerdes = Grouped.`with`(Serdes.Integer, Serdes.Integer)
    implicit val materializedIntsSerdes = Materialized.`with`[Int, Long, ByteArrayKeyValueStore]
    implicit val producedAgeSerdes = Produced.`with`[Int, Long]

    val builder = new StreamsBuilder
    val playersStream = builder.stream[String, Player](Player.TOPIC_NAME)
      .map((key, player) => (player.age, 1))
      .groupByKey(groupedIntsSerdes)
      .count()(materializedIntsSerdes)
      .toStream
      .through("Age")
      .foreach((age, count) => {
        _agesMap += (age -> count)
      })

    logger.info("Results:")
    //    print(playersStream.)

    val streams = new KafkaStreams(builder.build(), props)
    streams.cleanUp()
    streams.start()

    sys.ShutdownHookThread {
      streams.close(Duration.ofSeconds(10))
    }
  }
}
