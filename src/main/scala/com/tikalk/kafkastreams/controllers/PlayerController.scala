package com.tikalk.kafkastreams.controllers

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.ActionResult
import com.tikalk.kafkastreams.traits.Validator
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  val logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @PostMapping(value = Array("/newPlayer"))
  @ResponseBody
  def createNewPlayer(): Unit = {
    println("in create new player")
  }
}
