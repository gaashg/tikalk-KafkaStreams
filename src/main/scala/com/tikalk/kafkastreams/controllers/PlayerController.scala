package com.tikalk.kafkastreams.controllers

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, Person}
import com.tikalk.kafkastreams.services.PlayerService
import com.tikalk.kafkastreams.traits.Validator
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  val logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @Resource(name = "newPlayerValidator")
  val newPlayerValidator: Validator[Person] = null

  @Resource(name = "playerService")
  val playerService: PlayerService = null

  @PostMapping(value = Array("/newPlayer"))
  @ResponseBody
  def createNewPlayer(@RequestParam firstName : String, @RequestParam lastName : String, @RequestParam username : String): ActionResult = {
    logger.info("New Player; firstName={}, lastName={}, username={}", firstName, lastName, username)
    val person = new Person(firstName, lastName)
    if (newPlayerValidator.validate(person))
      playerService.createNewPlayer(person, username)
    else
      new ActionResult(false, ActionType.ADD_NEW_PLAYER, "Not validated", AnyRef)
  }
}
