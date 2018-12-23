package com.tikalk.kafkastreams.streams.games

import com.tikalk.kafkastreams.common.kafka.KafkaConstants
import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.serdes.PlayerSerde
import com.tikalk.kafkastreams.streams.utils.StreamsUtils
import javax.annotation.PostConstruct
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.scala.kstream.{Consumed, Grouped, Materialized}
import org.apache.kafka.streams.scala.{ByteArrayKeyValueStore, Serdes, StreamsBuilder}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component
class GamesStream {
  private val _logger: Logger = LoggerFactory.getLogger(classOf[GamesStream])

  @PostConstruct
  def run() = {
    fetchPlayers()
  }

  private def fetchPlayers() = {
    _logger.info("listening to Players topic")

    val props = StreamsUtils.initProperties()
    props.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)

    implicit val consumed = Consumed.`with`[String, Player](Serdes.String, new PlayerSerde)
    implicit val grouped = Grouped.`with`[String, Player](Serdes.String, new PlayerSerde)
    implicit val materialized = Materialized.`with`[String, Player, ByteArrayKeyValueStore](Serdes.String, new PlayerSerde)

    val builder: StreamsBuilder = new StreamsBuilder
    val playersKTable = builder.stream[String, Player](KafkaConstants.PLAYER_TOPIC_NAME).groupByKey
      .aggregate()
  }

}
