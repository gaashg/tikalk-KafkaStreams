package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.web.enums.ActionType
import com.tikalk.kafkastreams.common.model.ActionResult
import com.tikalk.kafkastreams.web.traits.Validator
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
