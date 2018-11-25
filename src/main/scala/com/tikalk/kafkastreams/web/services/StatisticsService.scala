package com.tikalk.kafkastreams.web.services

import com.tikalk.kafkastreams.common.model.PlayersStatistics
import com.tikalk.kafkastreams.streams.statistics.StatisticsStreamsService
import javax.annotation.Resource
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component ("statisticsService")
class StatisticsService {
  @Resource
  private val statisticsStreamsService : StatisticsStreamsService = null
  private val logger : Logger = LoggerFactory.getLogger(classOf[StatisticsService])
  def getPlayersStatistics(): Unit = {
    PlayersStatistics(statisticsStreamsService.agesMap)
  }
}
