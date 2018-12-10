package com.tikalk.kafkastreams.streams.games

import javax.annotation.PostConstruct
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Component

@Component
class GamesStream {
  private val _logger : Logger = LoggerFactory.getLogger(classOf[GamesStream])

  @PostConstruct
  def run () = {
    fetchPlayers()
  }

  private def fetchPlayers () = {
    _logger.info("listening to Players topic")

  }

}
