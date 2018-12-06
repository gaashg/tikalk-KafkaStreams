package com.tikalk.kafkastreams.streams.statistics

import java.time.Duration

import com.fasterxml.jackson.databind.ObjectMapper
import com.tikalk.kafkastreams.common.model.Player
import com.tikalk.kafkastreams.common.serdes.PlayerSerde
import com.tikalk.kafkastreams.streams.utils.StreamsUtils
import javax.annotation.{PostConstruct, Resource}
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.utils.Bytes
import org.apache.kafka.streams.kstream.Printed
import org.apache.kafka.streams.scala.kstream.{Consumed, Grouped, Materialized, Produced}
import org.apache.kafka.streams.scala.{ByteArrayKeyValueStore, Serdes, StreamsBuilder}
import org.apache.kafka.streams.state.{KeyValueStore, QueryableStoreTypes, ReadOnlyKeyValueStore}
import org.apache.kafka.streams.{KafkaStreams, KeyValue}
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class StatisticsStreamsService {
  private val logger = LoggerFactory.getLogger(classOf[StatisticsStreamsService])
  private var _kvStore : ReadOnlyKeyValueStore[Int, Long] = _

  @Resource
  private var objectMapper: ObjectMapper = _

  def agesMap = {
    var map = Map[Int, Long]()
    val iter = _kvStore.all()
    var entry : KeyValue[Int, Long] = null
    while (iter.hasNext){
      entry = iter.next()
      map += (entry.key -> entry.value)
    }

    map
  }



  @PostConstruct
  def stats() = {
    countPlayersAge()
  }

  def countPlayersAge(): Unit = {
    logger.info("Counting players' age")
/*
    val props = StreamsUtils.initProperties()
 /*   implicit val longImplicit = Serdes.Long
    implicit val intImplicit = Serdes.Integer
    implicit val stringImplicit = Serdes.String
    implicit val playerSerde: Serde[Player] = new PlayerEntitySerde
    implicit val consumedStringSerdes = Consumed.`with`(Serdes.String, playerSerde)
    implicit val groupedIntsSerdes = Grouped.`with`(Serdes.Integer, Serdes.Integer)
//    implicit val materializedIntsSerdes = Materialized.as("ageCountKVStore").asInstanceOf[Materialized[Int, Long, ByteArrayKeyValueStore]]
    implicit val materializedIntsSerdes = Materialized.`with`[Int, Long, ByteArrayKeyValueStore]
    implicit val producedAgeSerdes = Produced.`with`[Int, Long]
    Materialized.as("counts-store").asInstanceOf[Materialized[String, Long, KeyValueStore[Bytes, Array[Byte]]]]
*/

    val builder = new StreamsBuilder
/*    val playersStream = builder.stream[String, Player](Player.TOPIC_NAME)
      .map((key, player) => (player.age, 1))
      .groupByKey(groupedIntsSerdes)
      .count()(materializedIntsSerdes)
      .toStream
      .through("Age")
      .print(Printed.toSysOut[Int, Long])

    logger.info("Results:")
    //    print(playersStream.)
*/
    val streams = new KafkaStreams(builder.build(), props)
    streams.cleanUp()
    streams.start()

    Thread.sleep(5000)

//    _kvStore = streams.store("ageCountKVStore", QueryableStoreTypes.keyValueStore[Int, Long]())


    sys.ShutdownHookThread {
      streams.close(Duration.ofSeconds(10))
    }
    */
  }
}
