package com.tikalk.kafkastreams.streams.statistics

import com.fasterxml.jackson.databind.ObjectMapper
import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.streams.utils.StreamsUtils
import javax.annotation.Resource
import org.apache.kafka.streams.scala.{Serdes, StreamsBuilder}
import org.apache.kafka.streams.scala.kstream.{Consumed, Grouped, KStream, Materialized}
import org.springframework.stereotype.Service

@Service
class StatisticsStreamsService {
  private var _playerNum : Int = 0
  @Resource
  private var objectMapper : ObjectMapper = null

  def playerNum = _playerNum

  def countPlayersNum () : Unit = {
    val properties = StreamsUtils.initProperties()
    implicit val groupedStringIntSerdes = Grouped.`with`(Serdes.String, Serdes.Integer)
    val builder = new StreamsBuilder
    val playersStream = [String, String] = builder.stream[String, String]("Players")(Consumed.`with`(Serdes.String, Serdes.String))
      .groupBy((_, player) => "1")(Grouped.`with`(Serdes.String, Serdes.String))
//      .map((key, player) => ("1", 1))
//      .groupByKey(Grouped.`with`(Serdes.String, Serdes.Integer))
      .count()(Materialized.`with`(Serdes.String, Serdes.Integer))

//      .count()(Materialized.`with`(Serdes.String, Serdes.Integer))


  }

}
