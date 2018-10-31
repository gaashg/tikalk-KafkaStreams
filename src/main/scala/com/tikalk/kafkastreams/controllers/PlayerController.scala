package com.tikalk.kafkastreams.controllers

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, NewPlayer, Player}
import com.tikalk.kafkastreams.services.PlayerService
import com.tikalk.kafkastreams.traits.Validator
import javax.annotation.Resource
import javax.validation.constraints.NotNull
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  val logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @Resource(name = "newPlayerValidator")
  val newPlayerValidator: Validator[NewPlayer] = null

  @Resource(name = "playerService")
  val playerService: PlayerService = null

  @PostMapping(value = Array("/newPlayer"))
  @ResponseBody
  def createNewPlayer(@RequestBody @Validated newPlayer: NewPlayer): ActionResult = {
    logger.info("New Player: {}", newPlayer)
    if (newPlayerValidator.validate(newPlayer))
      playerService.createNewPlayer(newPlayer)
    else
      new ActionResult(false, ActionType.ADD_NEW_PLAYER, "Not validated", AnyRef)
  }
}
