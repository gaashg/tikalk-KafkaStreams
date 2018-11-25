package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.common.model.{Game, Player}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(path = Array ("/game"))
class GameController {

  @Autowired
  val producerFactory: KafkaProducer[String, Game] = null

  @PostMapping(path = Array ("/new"))
  def createNewGame (@RequestBody game: Game) : Unit = {
    println(s"The game is: $game")
    sendToKafka(game)
  }

  def sendToKafka(game: Game) = {
    val record = new ProducerRecord(Game.TOPIC_NAME, game.id, game)
    producerFactory.send(record);
  }

}