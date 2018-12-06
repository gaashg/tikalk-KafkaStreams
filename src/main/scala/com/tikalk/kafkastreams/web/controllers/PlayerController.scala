package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.common.model.{ActionResult, Player}
import com.tikalk.kafkastreams.web.services.PlayerService
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation._

@RestController
class PlayerController {
  private val _logger: Logger = LoggerFactory.getLogger(classOf[PlayerController])

  @Resource
  private val _playerService: PlayerService = null

  @PostMapping(path = Array("/player"))
  @ResponseBody
  def addNewPlayer(@RequestBody player: Player): ActionResult = {
    _playerService.addNewPlayer(player)
  }
}
