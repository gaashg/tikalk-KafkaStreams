package com.tikalk.kafkastreams.streams.statistics

import java.time.Duration

import com.fasterxml.jackson.databind.ObjectMapper
import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.utils.GeneralFactory
import com.tikalk.kafkastreams.streams.utils.StreamsUtils
import javax.annotation.{PostConstruct, Resource}
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.kstream.{Consumed, Grouped, Materialized, Produced}
import org.apache.kafka.streams.scala.{ByteArrayKeyValueStore, Serdes, StreamsBuilder}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service


@Service
class StatisticsStreamsService {
  private val logger = LoggerFactory.getLogger(classOf[StatisticsStreamsService])
  private var _playerNum: Int = 0
  @Resource
  private var objectMapper: ObjectMapper = null

  def playerNum = _playerNum

  @PostConstruct
  def countPlayersAge(): Unit = {
    logger.info("Counting players' age")

    val props = StreamsUtils.initProperties()
    implicit val stringSerde = Serdes.String
    implicit val intSerde = Serdes.Integer
    implicit val longSerde = Serdes.Long
    implicit val consumedStringSerdes = Consumed.`with`(Serdes.String, Serdes.String)
    implicit val groupedIntsSerdes = Grouped.`with`(Serdes.Integer, Serdes.Integer)
    implicit val materializedIntsSerdes = Materialized.`with`[Int, Long, ByteArrayKeyValueStore]
    implicit val producedAgeSerdes = Produced.`with`[Int, Long]

    val builder = new StreamsBuilder
    val playersStream = builder.stream[String, String]("Players")
      .map((key, playerJson) => (GeneralFactory.getObjectMapper().readValue(playerJson, classOf[Player]).age, 1))
      .groupByKey(groupedIntsSerdes)
      .count()(materializedIntsSerdes)
      .toStream
      .through("Age")
      .print(Printed.toSysOut[Int, Long])

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
