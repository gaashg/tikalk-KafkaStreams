package com.tikalk.kafkastreams.web.controllers

import java.util.Date

import com.tikalk.kafkastreams.common.model.{ActionResult, Player}
import com.tikalk.kafkastreams.common.utils.UUIDGenerator
import com.tikalk.kafkastreams.web.enums.ActionType
import javax.ws.rs.QueryParam
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  val logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @PostMapping(path = Array("/newPlayer") )
  @ResponseBody
  def createNewPlayer(@QueryParam name : String, @QueryParam age : Int): Unit = {
    val player = new Player(UUIDGenerator.generateUUID,(new Date()).getTime,name,age)
    println(s"in create new player $name")
    new ActionResult(true, ActionType.ADD_NEW_QUOTE, player.toString, AnyRef)

  }
}
