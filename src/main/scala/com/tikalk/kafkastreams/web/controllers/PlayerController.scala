package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.common.model.{ActionResult, Player}
import com.tikalk.kafkastreams.common.utils.UUIDGenerator
import com.tikalk.kafkastreams.web.enums.ActionType
import javax.ws.rs.QueryParam
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  val logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @Autowired val playerKafkaTemplate: KafkaTemplate[String, Player] = null

  @PostMapping(path = Array("/newPlayer"))
  @ResponseBody
  def createNewPlayer(@QueryParam(value = "name") name: String, @QueryParam(value = "age") age: Int): Unit = {
    val player = new Player(UUIDGenerator.generateUUID, System.currentTimeMillis(), name, age)
    playerKafkaTemplate.send(Player.TOPIC_NAME, player)
    println(s"in create new player $name")
    new ActionResult(true, ActionType.ADD_NEW_QUOTE, player.toString, AnyRef)

  }
}
