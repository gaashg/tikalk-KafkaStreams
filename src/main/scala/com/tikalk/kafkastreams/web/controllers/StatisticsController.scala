package com.tikalk.kafkastreams.web.controllers

import com.tikalk.kafkastreams.common.model.{ActionResult, PlayersStatistics}
import com.tikalk.kafkastreams.web.enums.ActionType
import com.tikalk.kafkastreams.web.services.StatisticsService
import javax.annotation.Resource
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, ResponseBody, RestController}

@RestController
class StatisticsController {
  @Resource
  val statisticsService : StatisticsService = null

  @GetMapping(value=Array("/players"))
  @ResponseBody
  def getPlayersStatistics () : ActionResult = {
    val statistics = statisticsService.getPlayersStatistics()
    ActionResult(true, ActionType.GET_PLAYERS_STATISTICS, null, statistics)
  }
}
