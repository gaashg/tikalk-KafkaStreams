package com.tikalk.kafkastreams.services

import com.tikalk.kafkastreams.enums.ActionType
import com.tikalk.kafkastreams.model.{ActionResult, NewPlayer, Player}
import com.tikalk.kafkastreams.utils.UUIDGenerator
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component("playerService")
class PlayerService {
  private val logger: Logger = LoggerFactory.getLogger(classOf[PlayerService])


  def createNewPlayer(newPlayer: NewPlayer): ActionResult = {
    val player = new Player (UUIDGenerator.generateUUID, newPlayer.firstName, newPlayer.lastName)

    new ActionResult(true, ActionType.ADD_NEW_PLAYER, null, AnyRef)
  }
}
