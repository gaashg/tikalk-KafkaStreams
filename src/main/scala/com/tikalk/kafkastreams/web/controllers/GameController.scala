package com.tikalk.kafkastreams.web.controllers

import java.time.Instant

import com.tikalk.kafkastreams.common.model.Game
import com.tikalk.kafkastreams.common.utils.UUIDGenerator
import com.tikalk.kafkastreams.web.enums.GameType
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array ("/game"))
class GameController {

  @Autowired
  val producerFactory: KafkaProducer[String, Game] = null

  @PostMapping(path = Array ("/new/{gameType}/{playerIds}"))
  def createNewGame (@PathVariable gameType: String, @PathVariable playerIds: String) : Unit = {

    val game = new Game(UUIDGenerator.generateUUID, Instant.now.getEpochSecond, GameType.withName(gameType), playerIds.split(","),null)
    println(s"The game is: $game")
    sendToKafka(game)
  }

  def sendToKafka(game: Game) = {
    val record = new ProducerRecord(Game.TOPIC_NAME, game.id, game)
    producerFactory.send(record);
  }

}